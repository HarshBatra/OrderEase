package com.cdac.orderease.service;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.exception.UserAlreadyPresentException;
import com.cdac.orderease.exception.UserNotFoundException;

public interface UserService {
//	register user
	UserDTO registerUser(UserDTO user) throws UserAlreadyPresentException;

	LoginUserDTO loginUser(LoginUserDTO loginUserDto) throws UserNotFoundException;
}
