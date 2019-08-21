package com.vetweb.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetweb.entities.User;
import com.vetweb.repositories.IUserRepository;
import com.vetweb.services.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;

	
	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User save(User user) {
		this.userRepository.save(user);
		return user;
	}

	
	public User findByName(String userName) {
		try {
			return userRepository.findByName(userName).get();
		} catch (NoSuchElementException exception) {
			return null;
		}
	}
	
	public User findByEmail(String email) {
		try {
			return userRepository.findByEmail(email).get();
		} catch (NoSuchElementException exception) {
			return null;
		}
	}

}
