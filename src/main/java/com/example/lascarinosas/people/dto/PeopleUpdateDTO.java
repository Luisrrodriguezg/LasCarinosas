package com.example.lascarinosas.people.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PeopleUpdateDTO(
        @NotBlank
        @Size(min = 2, max = 120)
        String name,
        @NotNull
        @Past
        LocalDate dateOfBirth,
        @NotBlank
        @Size(max = 120)
        String occupation,

        Long familyId
) {}

