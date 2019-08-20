package com.vetweb.controllers.auth;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class LoginForm {

	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String password;
	
	
	//Method get Authentication with Token
	public UsernamePasswordAuthenticationToken converterToUserPassAuthToken() {
		return new UsernamePasswordAuthenticationToken(this.email, this.password);
	}
	
	
}
