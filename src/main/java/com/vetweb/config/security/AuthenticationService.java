package com.vetweb.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vetweb.entities.User;
import com.vetweb.repositories.IUserRepository;

@Service
public class AuthenticationService implements UserDetailsService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository
				.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not founded"));
		
		
		// Return the contained value, if present, otherwise throw an exception
		return new UserPrincipal(user);
	}
	
	
}
