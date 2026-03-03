package com.example.lascarinosas.caseentity.controller;


import com.example.lascarinosas.caseentity.dtos.CaseCreateDTO;
import com.example.lascarinosas.caseentity.dtos.CaseResponseDTO;
import com.example.lascarinosas.caseentity.dtos.CaseUpdateDTO;
import com.example.lascarinosas.caseentity.services.CaseServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cases")
public class CaseController {

    private final CaseServices service;

    public CaseController(CaseServices service) {
        this.service = service;
    }

    @PostMapping
    public CaseResponseDTO create(@RequestBody @Valid CaseCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public CaseResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CaseResponseDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public CaseResponseDTO update(@PathVariable UUID id,
                                  @RequestBody @Valid CaseUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}