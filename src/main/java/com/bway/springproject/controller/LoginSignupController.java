package com.bway.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSignupController {

	@GetMapping("/loginsignup")
	public String GetLoginRegister() {
		
		return "LoginSignup";
	}
}
