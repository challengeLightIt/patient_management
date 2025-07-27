package com.challenge.Patient.registration.controller;

import com.challenge.Patient.registration.model.entity.PatientEntity;
import com.challenge.Patient.registration.model.request.PatientCreationRequest;
import com.challenge.Patient.registration.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientEntity> createPatient(
            @RequestPart("patient") @Valid PatientCreationRequest patientRequest,
            @RequestPart("documentPhoto") MultipartFile documentPhoto) throws IOException {

        return ResponseEntity.ok(patientService.addPatient(patientRequest, documentPhoto));
    }

    @GetMapping
    public ResponseEntity<List<PatientEntity>> getAll() {
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("{patientId}")
    public ResponseEntity<PatientEntity> getPatientById(@Valid @PathVariable(value = "patientId" ) Long patientId) {
        return ResponseEntity.ok(patientService.getPatientData(patientId));
    }
}
