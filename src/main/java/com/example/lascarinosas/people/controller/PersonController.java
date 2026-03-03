package com.example.lascarinosas.people.controller;

import com.example.lascarinosas.people.dtos.PersonCreateDTO;
import com.example.lascarinosas.people.dtos.PersonResponseDTO;
import com.example.lascarinosas.people.dtos.PersonUpdateDTO;
import com.example.lascarinosas.people.services.PersonServicesImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonServicesImpl service;

    public PersonController(PersonServicesImpl service) {
        this.service = service;
    }

    @PostMapping
    public PersonResponseDTO create(@RequestBody @Valid PersonCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public PersonResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<PersonResponseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/case/{caseId}")
    public List<PersonResponseDTO> getByCaseId(@PathVariable UUID caseId) {
        return service.getByCaseId(caseId);
    }

    @PutMapping("/{id}")
    public PersonResponseDTO update(@PathVariable UUID id,
                                    @RequestBody @Valid PersonUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}