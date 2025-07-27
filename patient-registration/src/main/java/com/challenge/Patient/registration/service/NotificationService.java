package com.challenge.Patient.registration.service;

import com.challenge.Patient.registration.model.entity.PatientEntity;

public interface NotificationService {

    void sendPatientCreatedEmail(PatientEntity patient);

    void sendSMS(String to, String subject, String body);
}