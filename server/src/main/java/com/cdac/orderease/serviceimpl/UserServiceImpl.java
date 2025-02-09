package com.cdac.orderease.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.entity.Users;
import com.cdac.orderease.exception.NoUsersFoundException;
import com.cdac.orderease.exception.UserAlreadyPresentException;
import com.cdac.orderease.exception.UserNotFoundException;
import com.cdac.orderease.mapper.UserMapper;
import com.cdac.orderease.repository.UserRepository;
import com.cdac.orderease.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
    private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
	@Override
	public UserDetails loginUserForSpringSecurity(String username) throws UserNotFoundException {
		Optional<Users> isUser = userRepository.findByUsername(username);
		if(isUser.isEmpty()) {
			throw new UserNotFoundException("User with username : " + username + " not found");
		}
		Users user = isUser.get();
		
		Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority(user.getRole()));
		
		return new User(user.getUsername(),user.getPassword(),authorities);
	}
	
	@Override
	public UserDTO registerUser(UserDTO userDto) throws UserAlreadyPresentException {
		if(userRepository.existsByUserEmail(userDto.getUserEmail())) {
			throw new UserAlreadyPresentException("User with Email Id : " + userDto.getUserEmail() + " already exists");
		}
		
		String password = passwordEncoder.encode(userDto.getPassword());
		
		userDto.setPassword(password);
		userDto.setRole(userDto.getRole());
		Users user = UserMapper.mapUserDtoToUser(userDto);
		
		Users savedUser = userRepository.save(user);
		return UserMapper.mapUserToUserDto(savedUser);
	}

	@Override
	public UserDTO loginUser(LoginUserDTO loginUserDto) throws UserNotFoundException {
		Optional<Users> isUser = userRepository.findByUsernameAndPassword(loginUserDto.getUsername(), loginUserDto.getPassword());
		if(isUser.isEmpty()) {
			throw new UserNotFoundException("User with username : " + loginUserDto.getUsername() + " and password : " + loginUserDto.getPassword() + " not found");
		}
		Users user = isUser.get();
		return UserMapper.mapUserToUserDto(user);
	}

	@Override
	public UserDTO getSingleUser(Long userId) throws UserNotFoundException {
		Optional<Users> userById = userRepository.findById(userId);
		if(userById.isEmpty()) {
			throw new UserNotFoundException("User with userid : " + userId + " doesnot exists");
		}
		Users user = userById.get();
		return UserMapper.mapUserToUserDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() throws NoUsersFoundException {
		List<Users> allUsers = userRepository.findAll();
		if(allUsers.isEmpty()) {
			throw new NoUsersFoundException("No user found");
		}
		return allUsers.stream()
				.map(UserMapper::mapUserToUserDto)
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(Long userId, UserDTO userDto) throws UserNotFoundException {
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with userid : " + userId + " doesnot exists"));
		user = UserMapper.mapUserDtoToUser(userDto);
		Users savedUser = userRepository.save(user);
		return UserMapper.mapUserToUserDto(savedUser);
	}
}
