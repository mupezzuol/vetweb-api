package com.vetweb.controller.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	private String email;
	private String password;
	
	
	//Method get Authentication with Token
	public UsernamePasswordAuthenticationToken converterToUserPassAuthToken() {
		return new UsernamePasswordAuthenticationToken(this.email, this.password);
	}
	
	
	//Getter's and Setter's
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
