package com.example.lascarinosas.people.dtos;

import com.example.lascarinosas.people.model.PersonRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PersonCreateDTO(

        @NotNull(message = "caseId is required")
        UUID caseId,

        @NotBlank(message = "firstName is required")
        @Size(min = 2, max = 120)
        String firstName,

        @NotBlank(message = "lastName is required")
        @Size(min = 2, max = 120)
        String lastName,

        @NotNull(message = "role is required")
        PersonRole role,

        @Size(max = 2000)
        String notes
) {}