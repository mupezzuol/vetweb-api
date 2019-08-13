package com.vetweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetweb.entities.Clinic;

@Repository
public interface IClinicRepository extends JpaRepository<Clinic, Long> {


}
