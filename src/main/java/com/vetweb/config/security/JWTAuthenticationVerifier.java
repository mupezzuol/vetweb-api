package com.vetweb.config.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//Verifies the token existence in a common request to authorize response
public class JWTAuthenticationVerifier implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Get authentication current
		Authentication authentication = TokenService.getTokenFromRequest((HttpServletRequest) request);

		// Force Authenticate
		SecurityContextHolder.getContext().setAuthentication(authentication);

		chain.doFilter(request, response);
		return;
	}

}
