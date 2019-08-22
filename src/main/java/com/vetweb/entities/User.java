package com.vetweb.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vetweb.models.dto.UserCreateDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity(name = "UserEntity")
@Table(name = "tbl_user")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull @NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotNull @NotEmpty @Length(min = 5)
	@Column(name = "email")
	private String email;
	
	@NotNull @NotEmpty
	@Column(name = "password_user")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "tbl_user_roles",
	joinColumns = @JoinColumn(
			name = "user_id", referencedColumnName = "userId"), 
	inverseJoinColumns = @JoinColumn(
		name = "role_id", referencedColumnName = "roleId"))
	private Set<Role> roles;
	
	private LocalDate inclusionDate;
	
	@ManyToOne
	@JoinColumn(name="fk_clinic")
	private Clinic clinic;
	


	//Constructor's
	public User(String name, String email, String password, Set<Role> profiles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		//this.profiles = profiles;
	}
	
	
	//Converter User TO List<UserCreateDTO>
	public List<UserCreateDTO> converterToListUserCreateDto(List<User> users) {
		List<UserCreateDTO> usersDto = new ArrayList<>();
		
		users.forEach( (user) -> {
			usersDto.add(user.convertToUserCreateDto(user));
		});
		
		return usersDto;
	}
	
	//Converter User TO UserCreateDTO
	public UserCreateDTO convertToUserCreateDto(User user) {
		return new UserCreateDTO(user);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
