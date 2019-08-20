package com.vetweb.enums;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public enum RoleEnum {

	ADMIN("ADMIN"), 
	CLINIC_OWNER("CLINIC_OWNER"),
	CLINIC_ASSISTANT("CLINIC_ASSISTANT");

	private String description;

	RoleEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
