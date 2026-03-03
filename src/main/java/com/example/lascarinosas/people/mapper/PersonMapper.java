package com.example.lascarinosas.people.mapper;

import com.example.lascarinosas.people.dtos.PersonCreateDTO;
import com.example.lascarinosas.people.dtos.PersonResponseDTO;
import com.example.lascarinosas.people.dtos.PersonUpdateDTO;
import com.example.lascarinosas.people.model.Person;

public class PersonMapper {

    private PersonMapper(){}

    public static PersonResponseDTO toResponse(Person person) {
        return new PersonResponseDTO(
                person.getId(),
                person.getCaseEntity().getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getRole(),
                person.getNotes()
        );
    }

    public static Person toEntity(PersonCreateDTO dto) {
        Person person = new Person();
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