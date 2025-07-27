package com.challenge.Patient.registration.service;

import com.challenge.Patient.registration.model.entity.PatientEntity;
import com.challenge.Patient.registration.model.request.PatientCreationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PatientService {

    PatientEntity addPatient(PatientCreationRequest patient, MultipartFile documentPhoto) throws IOException;
    PatientEntity getPatientData(Long patientId);
    List<PatientEntity> getAll();
}