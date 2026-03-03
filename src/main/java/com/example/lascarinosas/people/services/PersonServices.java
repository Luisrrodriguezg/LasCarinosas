package com.example.lascarinosas.people.services;

import com.example.lascarinosas.people.dto.PersonCreateDTO;
import com.example.lascarinosas.people.dto.PersonResponseDTO;
import com.example.lascarinosas.people.dto.PersonUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PersonServices{
    PersonResponseDTO create(PersonCreateDTO dto);

    PersonResponseDTO getById(UUID id);

    List<PersonResponseDTO> getAll();

    List<PersonResponseDTO> getByCaseId(UUID caseId);

    PersonResponseDTO update(UUID id, PersonUpdateDTO dto);

    void delete(UUID id);

}
