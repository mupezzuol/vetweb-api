package com.vetweb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "tbl_clinic")
public class Clinic {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cnpj;
	private String razaoSocial;
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


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
}
