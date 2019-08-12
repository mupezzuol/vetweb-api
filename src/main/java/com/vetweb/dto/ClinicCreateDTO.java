package com.vetweb.dto;

import com.vetweb.model.Clinic;

public class ClinicCreateDTO {
	
	private String cnpj;
	private String razaoSocial;
	private String owner;
	
	
	//Constructor's
	public ClinicCreateDTO(Clinic clinic) {
		super();
		this.cnpj = clinic.getCnpj();
		this.razaoSocial = clinic.getRazaoSocial();
		this.owner = clinic.getOwner();
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

}
