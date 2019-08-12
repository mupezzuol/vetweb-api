package com.vetweb.form;

import java.util.List;

import com.vetweb.model.Clinic;
import com.vetweb.model.User;

public class ClinicCreateForm {

	private String cnpj;
	private String razaoSocial;
	private String owner;
	private List<User> users;
	
	
	public Clinic converterToClinic() {
		return new Clinic(this.cnpj, this.razaoSocial, this.owner, this.users);
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
	
}
