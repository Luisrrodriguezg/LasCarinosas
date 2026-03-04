package com.example.lascarinosas.evidences.services;

import com.example.lascarinosas.evidences.dtos.EvidenceCreateDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceResponseDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface EvidenceServices {

    EvidenceResponseDTO create(EvidenceCreateDTO dto);

    EvidenceResponseDTO getById(UUID id);

    List<EvidenceResponseDTO> getByCaseId(UUID caseId);

    EvidenceResponseDTO update(UUID id, EvidenceUpdateDTO dto);

    void delete(UUID id);
}