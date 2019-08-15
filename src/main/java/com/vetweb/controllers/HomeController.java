package com.vetweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags="Welcome - Get Started - Home", description="Test Request")
@RestController
public class HomeController {
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "Welcome to the vetweb API. "
				+ "We make this endpoint available for simple API testing. "
				+ "For access any other end-point will need to authenticate via Token.";
	}

}
