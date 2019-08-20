package com.vetweb.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vetweb.enums.RoleEnum;

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
@Entity(name = "ProfileEntity")
@Table(name = "tbl_profile")
public class Profile implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	private RoleEnum role;
	
	@ManyToMany(mappedBy = "profiles")
	@JsonBackReference
	private List<User> users;
	

	@Override
	public String getAuthority() {
		return role.getDescription();
	}


}
