package com.example.lascarinosas.people.services;

import com.example.lascarinosas.caseentity.model.CaseEntity;
import com.example.lascarinosas.caseentity.repository.CaseRepository;
import com.example.lascarinosas.common.exception.NotFound;
import com.example.lascarinosas.people.model.Person;
import com.example.lascarinosas.people.dtos.PersonCreateDTO;
import com.example.lascarinosas.people.dtos.PersonResponseDTO;
import com.example.lascarinosas.people.dtos.PersonUpdateDTO;
import com.example.lascarinosas.people.mapper.PersonMapper;
import com.example.lascarinosas.people.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PersonServicesImpl implements PersonServices {

    private final PersonRepository repository;
    private final CaseRepository caseRepository;

    public PersonServicesImpl(PersonRepository repository,
                              CaseRepository caseRepository) {
        this.repository = repository;
        this.caseRepository = caseRepository;
    }

    @Override
    public PersonResponseDTO create(PersonCreateDTO dto) {

        CaseEntity caseEntity = caseRepository.findById(dto.caseId())
                .orElseThrow(() ->
                        new NotFound("Case not found with id: " + dto.caseId()));

        Person person = PersonMapper.toEntity(dto);
        person.setCaseEntity(caseEntity);

        Person saved = repository.save(person);

        return PersonMapper.toResponse(saved);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public PersonResponseDTO getById(UUID id) {

        Person person = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Person not found with id: " + id));

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

        if (!caseRepository.existsById(caseId)) {
            throw new NotFound("Case not found with id: " + caseId);
        }

        return repository.findByCaseEntityId(caseId)
                .stream()
                .map(PersonMapper::toResponse)
                .toList();
    }

    @Override
    public PersonResponseDTO update(UUID id, PersonUpdateDTO dto) {

        Person person = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Person not found with id: " + id));

        PersonMapper.updateEntity(dto, person);

        Person updated = repository.save(person);

        return PersonMapper.toResponse(updated);
    }

    @Override
    public void delete(UUID id) {

        if (!repository.existsById(id)) {
            throw new NotFound("Person not found with id: " + id);
        }

        repository.deleteById(id);
    }
}