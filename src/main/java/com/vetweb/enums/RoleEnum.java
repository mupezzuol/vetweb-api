package com.vetweb.enums;

public enum RoleEnum {

	ADMIN("admin"), 
	CLINIC_OWNER("clinic_owner"),
	CLINIC_ASSISTANT("clinic_assistant");

	private String description;

	RoleEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
