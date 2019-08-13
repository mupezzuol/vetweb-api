package com.vetweb.config.security;

import java.util.Optional;

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = this.userRepository.findByEmail(username);
		
		if(user.isPresent()) {
			return user.get(); // OK -> Return UserDetails
		}
		
		throw new UsernameNotFoundException("Login or password invalid");
	}
	
	
}
