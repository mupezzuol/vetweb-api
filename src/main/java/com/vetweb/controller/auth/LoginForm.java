package com.vetweb.controller.auth;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
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
