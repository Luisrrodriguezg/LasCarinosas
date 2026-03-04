package com.example.lascarinosas.tasks.dtos;

import com.example.lascarinosas.tasks.model.TaskPriority;
import com.example.lascarinosas.tasks.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TaskUpdateDTO(

        @NotBlank(message = "title is required")
        String title,

        String description,

        @NotNull(message = "status is required")
        TaskStatus status,

        @NotNull(message = "priority is required")
        TaskPriority priority,

        UUID assignedPersonId
) {}