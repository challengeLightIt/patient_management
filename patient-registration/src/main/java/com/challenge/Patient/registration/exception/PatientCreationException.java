package com.challenge.Patient.registration.exception;

public class PatientCreationException extends RuntimeException {
    public PatientCreationException(String email) {
        super("Patient already exists with email: " + email);
    }
}
