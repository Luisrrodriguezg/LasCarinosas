package com.example.lascarinosas.people.dtos;

import com.example.lascarinosas.people.model.PersonRole;

import java.util.UUID;

public record PersonResponseDTO(
        UUID id,
        UUID caseId,
        String firstName,
        String lastName,
        PersonRole role,
        String notes
) {}