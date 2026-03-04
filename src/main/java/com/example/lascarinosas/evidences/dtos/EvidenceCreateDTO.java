package com.example.lascarinosas.evidences.dtos;

import com.example.lascarinosas.evidences.model.EvidenceStatus;
import com.example.lascarinosas.evidences.model.EvidenceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record EvidenceCreateDTO(

        @NotNull(message = "caseId is required")
        UUID caseId,

        @NotBlank(message = "name is required")
        @Size(max = 255)
        String name,

        @Size(max = 2000)
        String description,

        @NotNull(message = "type is required")
        EvidenceType type,

        @NotNull(message = "status is required")
        EvidenceStatus status
) {}