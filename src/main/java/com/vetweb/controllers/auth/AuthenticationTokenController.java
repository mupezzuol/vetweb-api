package com.vetweb.controllers.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetweb.config.security.TokenService;

import io.swagger.annotations.Api;

@Api(tags="Authentication Token", description="Access token generation")
@RestController
@RequestMapping("/auth")
public class AuthenticationTokenController {
	
		@Autowired
		private AuthenticationManager authManager;
		
		@Autowired
		private TokenService tokenService;
		
		@PostMapping
		public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid LoginForm loginForm){
			
			UsernamePasswordAuthenticationToken login = loginForm.converterToUserPassAuthToken();
			
			try {
				Authentication authenticate = authManager.authenticate(login);//Class: AuthenticationService
				
				String token = tokenService.generateToken(authenticate);
				
				//Login Successfully Authenticated -> Return Token + Type
				return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
				
			} catch (AuthenticationException e) {
				return ResponseEntity.badRequest().build();//404
			}
			
		}

}
