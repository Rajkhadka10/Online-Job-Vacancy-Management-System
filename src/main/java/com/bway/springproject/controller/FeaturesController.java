package com.bway.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeaturesController {
	
	@GetMapping("/features")
	public String getAboutUs(){
		
		return "Features";
	}

}
