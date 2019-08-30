package com.vetweb.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetweb.entities.Permission;
import com.vetweb.entities.Role;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long>{
	
	public List<Permission> findByRoles(Set<Role> set);

}
