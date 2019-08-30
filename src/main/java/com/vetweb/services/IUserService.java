package com.vetweb.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.vetweb.entities.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public User save(User user);

	public User findByName(String name);
	
	public User findByEmail(String email);
	
	public Optional<User> findByUuid(UUID uuid);
	
}
