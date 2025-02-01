package com.cdac.orderease.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.entity.User;
import com.cdac.orderease.exception.UserAlreadyPresentException;
import com.cdac.orderease.exception.UserNotFoundException;
import com.cdac.orderease.mapper.UserMapper;
import com.cdac.orderease.repository.UserRepository;
import com.cdac.orderease.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO registerUser(UserDTO userDto) throws UserAlreadyPresentException {
		if(userRepository.existsByUserEmail(userDto.getUserEmail())) {
			throw new UserAlreadyPresentException("User with Email Id : " + userDto.getUserEmail() + " already exists");
		}
		User user = UserMapper.mapUserDtoToUser(userDto);
		User savedUser = userRepository.save(user);
		return UserMapper.mapUserToUserDto(savedUser);
	}

	@Override
	public LoginUserDTO loginUser(LoginUserDTO loginUserDto) throws UserNotFoundException {
		User user = UserMapper.mapLoginUserDtoToUser(loginUserDto);
		Optional<User> isUser = userRepository.findByUsernameAndPassword(loginUserDto.getUsername(), loginUserDto.getPassword());
		if(isUser.isEmpty()) {
			throw new UserNotFoundException("User with username : " + loginUserDto.getUsername() + " and password : " + loginUserDto.getPassword() + " not found");
		}
		return UserMapper.mapUserToLoginUserDto(user);
	}
}
