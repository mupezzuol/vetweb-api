package com.vetweb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetweb.model.Clinic;
import com.vetweb.repository.ClinicRepository;

@Service
public class ClinicService {
	
	@Autowired
	private ClinicRepository clinicRepository; 
	
	
	public Clinic save(Clinic Clinic) {
		return this.clinicRepository.save(Clinic);
	}


	public Optional<Clinic> findById(Long id) {
		return this.clinicRepository.findById(id);
	}


	public Clinic findByCnpj(String cnpj) {
		return this.clinicRepository.findByCnpj(cnpj);
	}
	
	
}
