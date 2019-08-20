package com.vetweb.models.form;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
public class UserCreateForm {
	
	private Long idClinic;

	@NotNull @NotEmpty
	private String name;
	
	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String password;
	
	@NotNull @NotEmpty
	private Set<Profile> roles;
		
	//Converter UserCreateForm TO User
	public User converterToUser() {
		return new User(
				this.name, 
				this.email, 
				new BCryptPasswordEncoder().encode(this.password),
				this.roles);
	}

	
}
