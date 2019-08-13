package com.vetweb.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetweb.entities.Clinic;
import com.vetweb.repositories.IClinicRepository;
import com.vetweb.services.IClinicService;

@Service
public class ClinicService implements IClinicService {
	
	@Autowired
	private IClinicRepository clinicRepository;

	
	@Override
	public Clinic save(Clinic Clinic) {
		return this.clinicRepository.save(Clinic);
	}

	@Override
	public Optional<Clinic> findById(Long id) {
		return this.clinicRepository.findById(id);
	}

	
}
