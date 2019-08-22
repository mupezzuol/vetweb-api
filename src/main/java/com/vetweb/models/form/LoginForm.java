package com.vetweb.models.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class LoginForm {

	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String password;
	
	private String authCode;
	
	//Method get Authentication with Token
	public UsernamePasswordAuthenticationToken converterToUserPassAuthToken() {
		return new UsernamePasswordAuthenticationToken(this.email, this.password);
	}
	
	
}
