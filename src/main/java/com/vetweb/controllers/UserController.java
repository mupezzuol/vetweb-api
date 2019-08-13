package com.vetweb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetweb.entities.Clinic;
import com.vetweb.entities.User;
import com.vetweb.models.dto.UserCreateDTO;
import com.vetweb.models.form.UserCreateForm;
import com.vetweb.services.IClinicService;
import com.vetweb.services.IUserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IClinicService clinicService;
	
	
	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	
	@PostMapping()
	public ResponseEntity<UserCreateDTO> save(@RequestBody @Valid UserCreateForm userCreateForm) {
		
		User user = userCreateForm.converterToUser();
		
		Optional<Clinic> optional = this.clinicService.findById(userCreateForm.getIdClinic());
		
		user.setClinic(optional.get());
		
		this.userService.save(user);
		
		return ResponseEntity.ok(new UserCreateDTO(user));
	}
	
	

}
