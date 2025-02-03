package com.cdac.orderease.service;

import java.util.List;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.exception.NoUsersFoundException;
import com.cdac.orderease.exception.UserAlreadyPresentException;
import com.cdac.orderease.exception.UserNotFoundException;

public interface UserService {
//	register user
	UserDTO registerUser(UserDTO userDto) throws UserAlreadyPresentException;

	UserDTO loginUser(LoginUserDTO loginUserDto) throws UserNotFoundException;

	UserDTO getSingleUser(Long userId) throws UserNotFoundException;

	List<UserDTO> getAllUsers() throws NoUsersFoundException;

	UserDTO updateUser(Long userId, UserDTO userDto) throws UserNotFoundException;
}
