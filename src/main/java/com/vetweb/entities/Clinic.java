package com.vetweb.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity(name = "ClinicEntity")
@Table(name = "tbl_clinic")
public class Clinic {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@Column(name = "owner")
	private String owner;
	
	@OneToMany(mappedBy = "clinic", 
			targetEntity = User.class, 
			fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL)
	private List<User> users;

	
	public Clinic(String cnpj, String razaoSocial, String owner, List<User> users) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.owner = owner;
		this.users = users;
	}

	
}
