package com.vetweb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.vetweb.enums.RoleEnum;

@Entity(name = "RoleEntity")
@Table(name = "tbl_role")
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	@Enumerated(value = EnumType.STRING)
	private RoleEnum name;
	
	
	public Role() {
		super();
	}


	@Override
	public String getAuthority() {
		return null;
	}

	
	//Getter's and Setter's
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleEnum getName() {
		return name;
	}

	public void setName(RoleEnum name) {
		this.name = name;
	}

}
