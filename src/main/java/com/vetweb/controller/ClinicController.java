package com.vetweb.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetweb.dto.ClinicCreateDTO;
import com.vetweb.form.ClinicCreateForm;
import com.vetweb.model.Clinic;
import com.vetweb.service.ClinicService;

@RestController
@RequestMapping("/v1/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	@Transactional
	@PostMapping()
	public ResponseEntity<ClinicCreateDTO> createClinicAndUser(@RequestBody ClinicCreateForm clinicCreateForm) {

		Clinic clinicAndUser = clinicCreateForm.converterToClinic();

		clinicAndUser.getUsers().forEach((user) -> {
			user.setClinic(clinicAndUser);
			user.setPasswordUser(new BCryptPasswordEncoder().encode(user.getPasswordUser()));
		});

		this.clinicService.save(clinicAndUser);

		return ResponseEntity.ok(new ClinicCreateDTO(clinicAndUser));
	}
	
	

}
