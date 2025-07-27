package com.challenge.Patient.registration.repository;

import com.challenge.Patient.registration.model.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    PatientEntity findByEmail(String email);

}
