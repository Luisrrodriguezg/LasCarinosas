package com.example.lascarinosas.caseentity.services;

import com.example.lascarinosas.caseentity.dtos.CaseCreateDTO;
import com.example.lascarinosas.caseentity.dtos.CaseResponseDTO;
import com.example.lascarinosas.caseentity.dtos.CaseUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface CaseServices {

    CaseResponseDTO create(CaseCreateDTO dto);

    CaseResponseDTO getById(UUID id);

    List<CaseResponseDTO> getAll();

    CaseResponseDTO update(UUID id, CaseUpdateDTO dto);

    void delete(UUID id);
}