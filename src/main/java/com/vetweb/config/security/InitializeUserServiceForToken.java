package com.vetweb.config.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vetweb.services.impl.UserService;

@Component
public class InitializeUserServiceForToken {

	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void injectOnStatic() {
		TokenService.setUserService(userService);
	}
	
}
