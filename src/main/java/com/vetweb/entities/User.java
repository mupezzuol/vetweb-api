package com.vetweb.entities;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "UserEntity")
@Table(name = "tbl_user")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotNull @NotEmpty @Length(min = 5)
	@Column(name = "email")
	private String email;
	
	@NotNull @NotEmpty
	@Column(name = "password_user")
	private String passwordUser;
	
	@NotNull @NotEmpty
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Role> roles;
	
	@ManyToOne
	@JoinColumn(name="fk_clinic")
	private Clinic clinic;
	
	//Constructor's
	public User() {
		super();
	}
	
	public User(Long id, String name, String email, String passwordUser, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwordUser = passwordUser;
		this.roles = roles;
	}
	
	public User(String name, String email, String passwordUser, Set<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.passwordUser = passwordUser;
		this.roles = roles;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public String getPassword() {
		return this.passwordUser;
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
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", passwordUser=" + passwordUser + ", roles="
				+ roles + "]";
	}

	
	//Getter's and Setter's
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

	public String getPasswordUser() {
		return passwordUser;
	}
	
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
}
