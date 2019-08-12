package com.vetweb.controller.auth;

public class TokenDTO {
	
	private String token;
	private String type;
	
	
	//Constructor's
	public TokenDTO(String token, String type) {
		super();
		this.token = token;
		this.type = type;
	}
	
	
	//Getter's and Setter's
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
