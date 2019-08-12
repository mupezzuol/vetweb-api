package com.vetweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetweb.model.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

	Clinic findByCnpj(String cnpj);

}
