package com.brasajava.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@RequestMapping(value="/")
	public String login() {
		return "Hello world!!";
	}

}
