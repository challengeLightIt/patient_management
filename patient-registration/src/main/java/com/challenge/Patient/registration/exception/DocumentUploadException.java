package com.challenge.Patient.registration.exception;

public class DocumentUploadException extends RuntimeException {
    public DocumentUploadException() {
        super("Failed to retrieve document photo URL");
    }
}
