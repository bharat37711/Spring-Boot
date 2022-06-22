package com.demoBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoBoot.config.JwtUtil;
import com.demoBoot.entity.UserPassword;
import com.demoBoot.service.UserPasswordService;



@RestController

@RequestMapping("/v2/user")
public class UserPasswordController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserPasswordService service;
	
	@Autowired
	private JwtUtil jwtUtil;
	

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserPassword obj) {

		return new ResponseEntity<>(service.addUser(obj), HttpStatus.CREATED);
	}

	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody UserPassword jwtRequest) throws Exception {

		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (UsernameNotFoundException e) {
			throw new Exception("Bad Credentials");
		}

		UserDetails userDetails = this.service.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtil.generateToken(userDetails);

		System.out.println(token);
		return new ResponseEntity<>(token, HttpStatus.CREATED);

	}
	


}
