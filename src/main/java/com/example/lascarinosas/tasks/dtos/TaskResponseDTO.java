package com.example.lascarinosas.tasks.dtos;

import com.example.lascarinosas.tasks.model.TaskPriority;
import com.example.lascarinosas.tasks.model.TaskStatus;

import java.util.UUID;

public record TaskResponseDTO(
        UUID id,
        UUID caseId,
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        UUID assignedPersonId
) {}