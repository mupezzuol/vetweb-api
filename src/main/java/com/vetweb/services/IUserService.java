package com.vetweb.services;

import java.util.List;

import com.vetweb.entities.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public User save(User user);
	
}
