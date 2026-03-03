package com.example.lascarinosas.people.dto;

import com.example.lascarinosas.people.model.PersonRole;

import java.time.Instant;
import java.util.UUID;

public record PersonResponseDTO(
        UUID id,
        UUID caseId,
        String firstName,
        String lastName,
        PersonRole role,
        String notes,
        Instant createdAt,
        Long version
) {}
