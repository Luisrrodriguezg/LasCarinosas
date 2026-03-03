package com.example.lascarinosas.caseentity.dtos;

import com.example.lascarinosas.caseentity.model.CasePriority;
import com.example.lascarinosas.caseentity.model.CaseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CaseUpdateDTO(

        @NotBlank(message = "title is required")
        @Size(max = 255)
        String title,

        @Size(max = 2000)
        String description,

        @NotNull(message = "status is required")
        CaseStatus status,

        @NotNull(message = "priority is required")
        CasePriority priority
) {}