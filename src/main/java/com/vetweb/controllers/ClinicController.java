package com.vetweb.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetweb.entities.Clinic;
import com.vetweb.models.dto.ClinicCreateDTO;
import com.vetweb.models.form.ClinicCreateForm;
import com.vetweb.services.IClinicService;

import io.swagger.annotations.Api;

@Api(tags="Clinic Controller", description="Controller Description and....")
@RestController
@RequestMapping("/v1/clinic")
public class ClinicController {

	@Autowired
	private IClinicService clinicService;

	@Transactional
	@PostMapping()
	public ResponseEntity<ClinicCreateDTO> createClinicAndUser(@RequestBody ClinicCreateForm clinicCreateForm) {

		Clinic clinicAndUser = clinicCreateForm.converterToClinic();

		clinicAndUser.getUsers().forEach((user) -> {
			user.setClinic(clinicAndUser);
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		});

		this.clinicService.save(clinicAndUser);
		return ResponseEntity.ok(new ClinicCreateDTO(clinicAndUser));
	}
	
	

}
