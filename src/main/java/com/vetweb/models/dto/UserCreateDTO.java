package com.vetweb.models.dto;

import java.util.Set;

import com.vetweb.entities.Role;
import com.vetweb.entities.User;

public class UserCreateDTO {

	private Long id;
	private String name;
	private String email;
	private Set<Role> roles;
	
	
	//Constructor's
	public UserCreateDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.roles = user.getRoles();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
