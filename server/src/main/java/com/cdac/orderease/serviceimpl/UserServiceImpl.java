package com.cdac.orderease.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.entity.User;
import com.cdac.orderease.exception.NoUsersFoundException;
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
	public UserDTO loginUser(LoginUserDTO loginUserDto) throws UserNotFoundException {
		Optional<User> isUser = userRepository.findByUsernameAndPassword(loginUserDto.getUsername(), loginUserDto.getPassword());
		if(isUser.isEmpty()) {
			throw new UserNotFoundException("User with username : " + loginUserDto.getUsername() + " and password : " + loginUserDto.getPassword() + " not found");
		}
		User user = isUser.get();
		return UserMapper.mapUserToUserDto(user);
	}

	@Override
	public UserDTO getSingleUser(Long userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userById = userRepository.findById(userId);
		if(userById.isEmpty()) {
			throw new UserNotFoundException("User with userid : " + userId + " doesnot exists");
		}
		User user = userById.get();
		return UserMapper.mapUserToUserDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() throws NoUsersFoundException {
		// TODO Auto-generated method stub
		List<User> allUsers = userRepository.findAll();
		if(allUsers.isEmpty()) {
			throw new NoUsersFoundException("No user found");
		}
		return allUsers.stream()
				.map(UserMapper::mapUserToUserDto)
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(Long userId, UserDTO userDto) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with userid : " + userId + " doesnot exists"));
		user = UserMapper.mapUserDtoToUser(userDto);
		User savedUser = userRepository.save(user);
		return UserMapper.mapUserToUserDto(savedUser);
	}
}
