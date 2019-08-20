package com.vetweb.models.dto;

import com.vetweb.entities.Clinic;

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
	

}
