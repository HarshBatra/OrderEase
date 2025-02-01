package com.cdac.orderease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.exception.UserAlreadyPresentException;
import com.cdac.orderease.exception.UserNotFoundException;
import com.cdac.orderease.service.UserService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto) throws UserAlreadyPresentException {
		UserDTO savedUser = userService.registerUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginUserDTO> loginUser(@RequestBody LoginUserDTO loginUserDto) throws UserNotFoundException {
		userService.loginUser(loginUserDto);
		return ResponseEntity.status(HttpStatus.FOUND).body(loginUserDto);
	}
	
}
