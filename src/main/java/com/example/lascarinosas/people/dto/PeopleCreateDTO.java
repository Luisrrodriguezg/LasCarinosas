package com.example.lascarinosas.people.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record PeopleCreateDTO(
        @NotBlank(message = "name is required")
        @Size(min = 2, max = 120, message = "name must be between 2 and 120 characters")
        String name,

        @NotNull(message = "dateOfBirth is required")
        @Past(message = "dateOfBirth must be in the past")
        LocalDate dateOfBirth,

        @Size(max = 120)
        String occupation,

        Long familyId
) {
}
