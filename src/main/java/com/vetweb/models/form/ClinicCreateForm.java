package com.vetweb.models.form;

import java.util.List;

import com.vetweb.entities.Clinic;
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
public class ClinicCreateForm {

	private String cnpj;
	private String razaoSocial;
	private String owner;
	private List<User> users;
	
	
	public Clinic converterToClinic() {
		return new Clinic(this.cnpj, this.razaoSocial, this.owner, this.users);
	}
	
	
}
