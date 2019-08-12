package com.vetweb.form;

import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vetweb.model.Role;
import com.vetweb.model.User;

public class UserCreateForm {

	private String name;
	private String email;
	private String password;
	private Set<Role> roles;
		
	//Converter TopicoForm TO Topico
	public User converterToUser() {
		return new User(
				this.name, 
				this.email, 
				new BCryptPasswordEncoder().encode(this.password),
				this.roles);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
		
}
