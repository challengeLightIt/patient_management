package com.challenge.Patient.registration.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long id) {
        super("Patient with id: " + id + " does not exist");
    }
}
