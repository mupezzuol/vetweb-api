package com.vetweb.config.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetweb.entities.User;
import com.vetweb.models.form.LoginForm;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JWTLoginFilter.class);
	
	
	public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authenticationManager);
	}
	
	// Attemp Login
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		LOGGER.info("Authenticating from " + request.getRequestURI());
		
		LoginForm user = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);
		
		Authentication auth = getAuthenticationManager()
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), Collections.emptyList()));
		return auth;
	}
	
	
	// Success Login
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		LOGGER.info("Authenticated with success, invoking handler");
		
		response.addHeader("Access-Control-Expose-Headers", "Authorization");
		
		UserPrincipal user = (UserPrincipal) authResult.getPrincipal();
		
		if (user == null) {
			throw new BadCredentialsException("Invalid credentials provided for authentication");
		}
		
		TokenService.addTokenToResponse(response, user.getUser().getEmail());
	}
	

}
