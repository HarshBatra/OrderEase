package com.cdac.orderease.mapper;

import com.cdac.orderease.dto.LoginUserDTO;
import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.entity.User;

public class UserMapper {
	public static User mapUserDtoToUser(UserDTO userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setUsername(userDto.getUsername());
		user.setUserEmail(userDto.getUserEmail());
		user.setPassword(userDto.getPassword());
		user.setPhoneNo(userDto.getPhoneNo());
		user.setRoles(userDto.getRoles());
		user.setOrderList(userDto.getOrderList());
		return user;
	}
	
	public static UserDTO mapUserToUserDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		userDto.setUserEmail(user.getUserEmail());
		userDto.setPassword(user.getPassword());
		userDto.setPhoneNo(user.getPhoneNo());
		userDto.setRoles(user.getRoles());
		userDto.setOrderList(user.getOrderList());
		return userDto;
	}

	public static User mapLoginUserDtoToUser(LoginUserDTO loginUserDto) {
		User user = new User();
		user.setUsername(loginUserDto.getUsername());
		user.setPassword(loginUserDto.getPassword());
		return user;
	}
	
	public static LoginUserDTO mapUserToLoginUserDto(User user) {
		LoginUserDTO loginUserDto = new LoginUserDTO();
		loginUserDto.setUsername(user.getUsername());
		loginUserDto.setPassword(user.getPassword());
		return loginUserDto;
	}
}
