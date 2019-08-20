package com.vetweb.models.dto;

import java.util.Set;

import com.vetweb.entities.Profile;
import com.vetweb.entities.User;

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
public class UserCreateDTO {

	private Long id;
	private String name;
	private String email;
	private Set<Profile> roles;
	
	
	//Constructor's
	public UserCreateDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.roles = user.getProfiles();
	}

	
}
