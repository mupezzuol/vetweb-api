package com.vetweb.services;

import java.util.Optional;

import com.vetweb.entities.Clinic;

public interface IClinicService {

	public Clinic save(Clinic Clinic);

	public Optional<Clinic> findById(Long id);

}
