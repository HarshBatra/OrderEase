package com.cdac.orderease.mapper;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.entity.Users;

public class UserMapper {
	public static Users mapUserDtoToUser(UserDTO userDto) {
		Users user = new Users();
		user.setUserId(userDto.getUserId());
		user.setUsername(userDto.getUsername());
		user.setUserEmail(userDto.getUserEmail());
		user.setPassword(userDto.getPassword());
		user.setPhoneNo(userDto.getPhoneNo());
		user.setRole(userDto.getRole());
		user.setOrderList(userDto.getOrderList());
		return user;
	}
	
	public static UserDTO mapUserToUserDto(Users user) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		userDto.setUserEmail(user.getUserEmail());
		userDto.setPassword(user.getPassword());
		userDto.setPhoneNo(user.getPhoneNo());
		userDto.setRole(user.getRole());
		userDto.setOrderList(user.getOrderList());
		return userDto;
	}

	public static Users mapLoginUserDtoToUser(LoginUserDTO loginUserDto) {
		Users user = new Users();
		user.setUsername(loginUserDto.getUsername());
		user.setPassword(loginUserDto.getPassword());
		return user;
	}
	
	public static LoginUserDTO mapUserToLoginUserDto(Users user) {
		LoginUserDTO loginUserDto = new LoginUserDTO();
		loginUserDto.setUsername(user.getUsername());
		loginUserDto.setPassword(user.getPassword());
		return loginUserDto;
	}
}
