package com.example.lascarinosas.evidences.mapper;

import com.example.lascarinosas.evidences.dtos.EvidenceCreateDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceResponseDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceUpdateDTO;
import com.example.lascarinosas.evidences.model.Evidence;

public class EvidenceMapper {

    private EvidenceMapper(){}

    public static EvidenceResponseDTO toResponse(Evidence evidence) {
        return new EvidenceResponseDTO(
                evidence.getId(),
                evidence.getCaseEntity().getId(),
                evidence.getName(),
                evidence.getDescription(),
                evidence.getType(),
                evidence.getStatus()
        );
    }

    public static Evidence toEntity(EvidenceCreateDTO dto) {
        Evidence evidence = new Evidence();
        evidence.setName(dto.name());
        evidence.setDescription(dto.description());
        evidence.setType(dto.type());
        evidence.setStatus(dto.status());
        return evidence;
    }

    public static void updateEntity(EvidenceUpdateDTO dto, Evidence evidence) {
        evidence.setName(dto.name());
        evidence.setDescription(dto.description());
        evidence.setType(dto.type());
        evidence.setStatus(dto.status());
    }
}