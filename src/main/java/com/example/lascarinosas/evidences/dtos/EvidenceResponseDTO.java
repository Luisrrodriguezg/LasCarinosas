package com.example.lascarinosas.evidences.dtos;

import com.example.lascarinosas.evidences.model.EvidenceStatus;
import com.example.lascarinosas.evidences.model.EvidenceType;

import java.util.UUID;

public record EvidenceResponseDTO(
        UUID id,
        UUID caseId,
        String name,
        String description,
        EvidenceType type,
        EvidenceStatus status
) {}