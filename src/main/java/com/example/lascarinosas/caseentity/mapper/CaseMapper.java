package com.example.lascarinosas.caseentity.mapper;

import com.example.lascarinosas.caseentity.dtos.CaseCreateDTO;
import com.example.lascarinosas.caseentity.dtos.CaseResponseDTO;
import com.example.lascarinosas.caseentity.dtos.CaseUpdateDTO;
import com.example.lascarinosas.caseentity.model.CaseEntity;

public class CaseMapper {

    private CaseMapper(){}

    public static CaseResponseDTO toResponse(CaseEntity caseEntity) {
        return new CaseResponseDTO(
                caseEntity.getId(),
                caseEntity.getTitle(),
                caseEntity.getDescription(),
                caseEntity.getStatus(),
                caseEntity.getPriority(),
                caseEntity.getPeople() != null ? caseEntity.getPeople().size() : 0,
                caseEntity.getEvidences() != null ? caseEntity.getEvidences().size() : 0,
                caseEntity.getTasks() != null ? caseEntity.getTasks().size() : 0
        );
    }

    public static CaseEntity toEntity(CaseCreateDTO dto) {
        CaseEntity caseEntity = new CaseEntity();
        caseEntity.setTitle(dto.title());
        caseEntity.setDescription(dto.description());
        caseEntity.setStatus(dto.status());
        caseEntity.setPriority(dto.priority());
        return caseEntity;
    }

    public static void updateEntity(CaseUpdateDTO dto, CaseEntity caseEntity) {
        caseEntity.setTitle(dto.title());
        caseEntity.setDescription(dto.description());
        caseEntity.setStatus(dto.status());
        caseEntity.setPriority(dto.priority());
    }
}
