package com.brasajava.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;


@RestController
public class LoginController {
	
	@ApiOperation(value="Login")
	@RequestMapping(value = "/public/login", method= RequestMethod.POST)
	public String login(@RequestParam(required=true)String username, @RequestParam(required=true)String password) {
		return "Hello world !! " + username + password;
	}

}
