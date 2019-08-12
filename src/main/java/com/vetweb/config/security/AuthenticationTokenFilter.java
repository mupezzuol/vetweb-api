package com.vetweb.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vetweb.model.User;
import com.vetweb.repository.UserRepository;

public class AuthenticationTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private UserRepository userRepository;
	
	
	// Manual dependency injection
	public AuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
		super();
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recoverToken(request);
		boolean validToken = tokenService.isValidToken(token);
		
	
		if(validToken) {
			authenticateClient(token);// Forcing Client Authentication for Spring
		}
		
		//Can continue
		filterChain.doFilter(request, response);
	}
	
	
	private void authenticateClient(String token) {
		Long isUser = tokenService.getIdUser(token);
		User user = userRepository.findById(isUser).get();
		
		//User + Password + Roles
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		
		//Here force Authentication
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	
	private String recoverToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
		
	
}
