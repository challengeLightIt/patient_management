package com.challenge.Patient.registration.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class PatientCreationRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String surname;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String phoneNumber;
}
