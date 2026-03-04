package com.example.lascarinosas.evidences.services;

import com.example.lascarinosas.caseentity.model.CaseEntity;
import com.example.lascarinosas.caseentity.repository.CaseRepository;
import com.example.lascarinosas.common.exception.NotFound;
import com.example.lascarinosas.evidences.dtos.EvidenceCreateDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceResponseDTO;
import com.example.lascarinosas.evidences.dtos.EvidenceUpdateDTO;
import com.example.lascarinosas.evidences.mapper.EvidenceMapper;
import com.example.lascarinosas.evidences.model.Evidence;
import com.example.lascarinosas.evidences.repository.EvidenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EvidenceServicesImpl implements EvidenceServices {

    private final EvidenceRepository repository;
    private final CaseRepository caseRepository;

    public EvidenceServicesImpl(EvidenceRepository repository,
                                CaseRepository caseRepository) {
        this.repository = repository;
        this.caseRepository = caseRepository;
    }

    @Override
    public EvidenceResponseDTO create(EvidenceCreateDTO dto) {

        CaseEntity caseEntity = caseRepository.findById(dto.caseId())
                .orElseThrow(() ->
                        new NotFound("Case not found with id: " + dto.caseId()));

        Evidence evidence = EvidenceMapper.toEntity(dto);
        evidence.setCaseEntity(caseEntity);

        return EvidenceMapper.toResponse(repository.save(evidence));
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public EvidenceResponseDTO getById(UUID id) {

        Evidence evidence = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Evidence not found with id: " + id));

        return EvidenceMapper.toResponse(evidence);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<EvidenceResponseDTO> getByCaseId(UUID caseId) {

        if (!caseRepository.existsById(caseId)) {
            throw new NotFound("Case not found with id: " + caseId);
        }

        return repository.findByCaseEntityId(caseId)
                .stream()
                .map(EvidenceMapper::toResponse)
                .toList();
    }

    @Override
    public EvidenceResponseDTO update(UUID id, EvidenceUpdateDTO dto) {

        Evidence evidence = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Evidence not found with id: " + id));

        EvidenceMapper.updateEntity(dto, evidence);

        return EvidenceMapper.toResponse(repository.save(evidence));
    }

    @Override
    public void delete(UUID id) {

        if (!repository.existsById(id)) {
            throw new NotFound("Evidence not found with id: " + id);
        }

        repository.deleteById(id);
    }
}