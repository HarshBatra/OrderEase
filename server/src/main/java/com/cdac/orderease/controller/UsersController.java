package com.cdac.orderease.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.UserDTO;
import com.cdac.orderease.entity.Users;
import com.cdac.orderease.exception.NoUsersFoundException;
import com.cdac.orderease.exception.UserAlreadyPresentException;
import com.cdac.orderease.exception.UserNotFoundException;
import com.cdac.orderease.jwtutil.JwtUtils;
import com.cdac.orderease.repository.UserRepository;
import com.cdac.orderease.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")  
public class UsersController {

	@Autowired
	private UserService userService;
	
	private  final UserRepository userRepository;
	
	private final JwtUtils jwtUtils;
	
    private final PasswordEncoder passwordEncoder;
	
	public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtil;
    }
	
	@PostMapping("/auth/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto) throws UserAlreadyPresentException {
		UserDTO savedUser = userService.registerUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<Object> loginUser(@RequestBody Map<String,String> request) throws UserNotFoundException {
		String username = request.get("username");
		String password = request.get("password");
		
		Optional<Users> user = userRepository.findByUsername(username);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with Username " + username + "Not found");
		}
		
		if(user.isPresent() && passwordEncoder.matches(password,user.get().getPassword())) {
			String token = jwtUtils.generateToken(username, user.get().getRole());
			Map<String, Object> response = new HashMap<>();
	        response.put("token", token);
	        response.put("user", user.get());

	        return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something Went Worng");
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable Long userId) throws UserNotFoundException {
		UserDTO userDto = userService.getSingleUser(userId);
		return ResponseEntity.ok(userDto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() throws NoUsersFoundException {
		List<UserDTO> userDtoList = userService.getAllUsers();
		return ResponseEntity.ok(userDtoList);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/user/{userId}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDto) throws UserNotFoundException {
		UserDTO updatedUser = userService.updateUser(userId, userDto);
		return ResponseEntity.ok(updatedUser);
	}
	
}
