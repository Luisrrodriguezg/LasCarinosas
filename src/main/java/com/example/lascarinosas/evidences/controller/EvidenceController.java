package com.example.lascarinosas.evidences.controller;

import com.example.lascarinosas.evidences.dtos.EvidenceCreateDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceResponseDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceUpdateDTO;
import com.example.lascarinosas.evidences.services.EvidenceServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evidences")
public class EvidenceController {

    private final EvidenceServices service;

    public EvidenceController(EvidenceServices service) {
        this.service = service;
    }

    @PostMapping
    public EvidenceResponseDTO create(@RequestBody @Valid EvidenceCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EvidenceResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/case/{caseId}")
    public List<EvidenceResponseDTO> getByCaseId(@PathVariable UUID caseId) {
        return service.getByCaseId(caseId);
    }

    @PutMapping("/{id}")
    public EvidenceResponseDTO update(@PathVariable UUID id,
                                      @RequestBody @Valid EvidenceUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}