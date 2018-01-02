package com.brasajava.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.model.User;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
public class LoginController {
	
	@ApiOperation(value="Login")
	@RequestMapping(value = "/public/login", method= RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody(required=false) User us) {
		User user = new User();
		user.setEmail("ricardomaximino@hotmail.com");
		user.setUserId(8984729349L);
		user.setUsername("Ricardo Maximino");
		user.setPassword("Ricardo2");
		if(user.getUsername().equals(us.getUsername()) && user.getPassword().equals(us.getPassword())) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
		System.out.println("Sent Username: " + us.getUsername() + " sent password: " + us.getPassword());
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
