package com.vetweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetweb.dto.UserCreateDTO;
import com.vetweb.form.UserCreateForm;
import com.vetweb.model.User;
import com.vetweb.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<UserCreateDTO> save(@RequestBody UserCreateForm userCreateForm) {
		
		User user = userCreateForm.converterToUser();
		
		this.userService.save(user);
		
		return ResponseEntity.ok(new UserCreateDTO(user));
	}
	
	

}
