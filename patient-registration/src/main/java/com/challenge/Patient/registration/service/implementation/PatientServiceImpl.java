package com.challenge.Patient.registration.service.implementation;

import com.challenge.Patient.registration.model.entity.PatientEntity;
import com.challenge.Patient.registration.model.request.PatientCreationRequest;
import com.challenge.Patient.registration.repository.PatientRepository;
import com.challenge.Patient.registration.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;


    @Override
    public PatientEntity addPatient(PatientCreationRequest patient, MultipartFile documentPhoto) throws IOException {
        var patientExisted = patientRepository.findByEmail(patient.getEmail());

        if (patientExisted!=null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(409));
        }

        var newPatientToSave = PatientEntity.builder().email(patient.getEmail()).
                phoneNumber(patient.getPhoneNumber()).name(patient.getName()).surname(patient.getSurname()).
                documentPicture(null).build();

        PatientEntity savedPatient = patientRepository.save(newPatientToSave);

        return savedPatient;

    }

    @Override
    public PatientEntity getPatientData(Long patientId) {
        var patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
    }

    @Override
    public List<PatientEntity> getAll() {
        return patientRepository.findAll();
    }
}
