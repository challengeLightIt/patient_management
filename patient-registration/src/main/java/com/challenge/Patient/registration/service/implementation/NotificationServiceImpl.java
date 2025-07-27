package com.challenge.Patient.registration.service.implementation;

import com.challenge.Patient.registration.model.entity.PatientEntity;
import com.challenge.Patient.registration.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String fromEmail;


    @Override
    public void sendPatientCreatedEmail(PatientEntity patient) {
        sendEmail(patient.getEmail(), "Patient Registration Successful", "Dear " +
                patient.getName() + " " + patient.getSurname() + ",\n\n" +
                "Your registration has been successfully completed.\n\n" +
                "Thank you for providing your information. You can now access our services using " +
                "your registered email address.\n\n" +
                "Best regards,\nThe Patient Registration Team");
    }

    private void sendEmail(String to, String subject, String body) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom(fromEmail);

            mailSender.send(message);

            log.info("Confirmation email sent successfully to {}", to);
        } catch (Exception e) {
            log.error("Failed to send email to {}: {}", to, e.getMessage());
        }
    }

    @Override
    public void sendSMS(String to, String subject, String body) {

    }

}
