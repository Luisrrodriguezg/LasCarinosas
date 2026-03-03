package com.example.lascarinosas.people.mapper;

import com.example.lascarinosas.people.dto.PersonCreateDTO;
import com.example.lascarinosas.people.dto.PersonResponseDTO;
import com.example.lascarinosas.people.dto.PersonUpdateDTO;
import com.example.lascarinosas.people.model.Person;
import org.springframework.stereotype.Component;

public class PersonMapper {

    private PersonMapper(){}

    public static PersonResponseDTO toResponse(Person person) {
        return new PersonResponseDTO(
                person.getId(),
                person.getCaseId(),
                person.getFirstName(),
                person.getLastName(),
                person.getRole(),
                person.getNotes(),
                person.getCreatedAt(),
                person.getVersion()
        );
    }

    public static Person toEntity(PersonCreateDTO dto) {
        Person person = new Person();
        person.setCaseId(dto.caseId());
        person.setFirstName(dto.firstName());
        person.setLastName(dto.lastName());
        person.setRole(dto.role());
        person.setNotes(dto.notes());
        return person;
    }

    public static void updateEntity(PersonUpdateDTO dto, Person person) {
        person.setFirstName(dto.firstName());
        person.setLastName(dto.lastName());
        person.setRole(dto.role());
        person.setNotes(dto.notes());
    }
}