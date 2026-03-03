package com.example.lascarinosas.people.services;

import com.example.lascarinosas.people.model.Person;
import com.example.lascarinosas.people.dto.PersonCreateDTO;
import com.example.lascarinosas.people.dto.PersonResponseDTO;
import com.example.lascarinosas.people.dto.PersonUpdateDTO;
import com.example.lascarinosas.people.mapper.PersonMapper;
import com.example.lascarinosas.people.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PersonServicesImpl implements PersonServices {

    private final PersonRepository repository;

    public PersonServicesImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonResponseDTO create(PersonCreateDTO dto) {
        Person person = PersonMapper.toEntity(dto);
        Person saved = repository.save(person);
        return PersonMapper.toResponse(saved);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public PersonResponseDTO getById(UUID id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
        return PersonMapper.toResponse(person);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PersonResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(PersonMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PersonResponseDTO> getByCaseId(UUID caseId) {
        return repository.findByCaseId(caseId)
                .stream()
                .map(PersonMapper::toResponse)
                .toList();
    }

    @Override
    public PersonResponseDTO update(UUID id, PersonUpdateDTO dto) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        PersonMapper.updateEntity(dto, person);

        Person updated = repository.save(person);

        return PersonMapper.toResponse(updated);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Person not found");
        }
        repository.deleteById(id);
    }
}