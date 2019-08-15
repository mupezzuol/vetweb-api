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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="User Controller", description="Controller Description and....")
@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IClinicService clinicService;
	
	
	@ApiOperation(value = "Find all Users.")
	@GetMapping()
	public ResponseEntity<List<UserCreateDTO>> findAll() {
		List<User> users = this.userService.findAll();
		List<UserCreateDTO> usersDto = new User().converterToListUserCreateDto(users);
		return ResponseEntity.ok(usersDto);
	}
	
	
	//Docs for Swagger
	@ApiOperation(
			value = "Create User passing the Clinic ID", 
			response = UserCreateDTO.class,
			notes="This operation creates a new clinical user by passing the clinic ID.")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Returns a UserCreateDTO with a success message.", response=UserCreateDTO.class),
	    @ApiResponse(code = 201, message = "Return message if status code is 201"),
	    @ApiResponse(code = 401, message = "Return message if status code is 401"),
	    @ApiResponse(code = 403, message = "Return message if status code is 403"),
	    @ApiResponse(code = 404, message = "Return message if status code is 404")
	})
	@PostMapping()
	public ResponseEntity<UserCreateDTO> createUser(@RequestBody @Valid UserCreateForm userCreateForm) {
		User user = userCreateForm.converterToUser();
		Optional<Clinic> optional = this.clinicService.findById(userCreateForm.getIdClinic());
		user.setClinic(optional.get());
		this.userService.save(user);
		return ResponseEntity.ok(new UserCreateDTO(user));
	}
	
	

}
