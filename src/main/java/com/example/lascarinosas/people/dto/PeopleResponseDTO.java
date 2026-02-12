package com.example.lascarinosas.people.dto;

import java.time.LocalDate;
import java.util.List;

public record PeopleResponseDTO(

        Long id,
        String name,
        Integer age,
        LocalDate dateOfBirth,
        String occupation,
        Long familyId,
        List<String> propertiesList
) {}
