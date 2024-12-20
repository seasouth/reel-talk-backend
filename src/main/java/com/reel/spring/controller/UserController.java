/**
package com.reel.spring.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reel.spring.config.JwtTokenProvider;
import com.reel.spring.model.User;
import com.reel.spring.repository.UserRepository;
import com.reel.spring.service.UserService;
import com.reel.spring.web.dto.UserSignUpDto;
*/

/**
@CrossOrigin
@RestController
@RequestMapping("user/")
public class UserController {
		
	@Autowired
	private AuthenticationManager authenticationManager;

	//@Autowired
	//private JwtUtil jwtTokenUtil;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// Get Users
	@GetMapping("/users")
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}
	
	// Create User rest api
	@PostMapping("/newuser")
	public User signUpNewUser(@RequestBody UserSignUpDto signUpDto) {
		return userService.save(signUpDto);
	}
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authenticate(@RequestBody User user) {
		Authentication authentication = authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (authentication.isAuthenticated()) {
			String username = user.getUsername();
			hashMap.put("name", authentication.getName());
			hashMap.put("authorities", authentication.getAuthorities());
			hashMap.put("token", 
					tokenProvider.createToken(username, userRepository.findByUsername(username).getRoles()));
		}
		
		String json;
		try {
			json = new ObjectMapper().writeValueAsString(hashMap);
			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
*/