package com.example.lascarinosas.caseentity.dtos;

import com.example.lascarinosas.caseentity.model.CasePriority;
import com.example.lascarinosas.caseentity.model.CaseStatus;

import java.util.UUID;

public record CaseResponseDTO(
        UUID id,
        String title,
        String description,
        CaseStatus status,
        CasePriority priority,
        int peopleCount,
        int evidenceCount,
        int taskCount
) {}