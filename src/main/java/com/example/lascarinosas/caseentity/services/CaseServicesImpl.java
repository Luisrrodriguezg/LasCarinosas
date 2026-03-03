package com.example.lascarinosas.caseentity.services;

import com.example.lascarinosas.caseentity.dtos.CaseCreateDTO;
import com.example.lascarinosas.caseentity.dtos.CaseResponseDTO;
import com.example.lascarinosas.caseentity.dtos.CaseUpdateDTO;
import com.example.lascarinosas.caseentity.mapper.CaseMapper;
import com.example.lascarinosas.caseentity.model.CaseEntity;
import com.example.lascarinosas.caseentity.repository.CaseRepository;
import com.example.lascarinosas.common.exception.NotFound;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CaseServicesImpl implements CaseServices {

    private final CaseRepository repository;

    public CaseServicesImpl(CaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CaseResponseDTO create(CaseCreateDTO dto) {

        CaseEntity caseEntity = CaseMapper.toEntity(dto);
        CaseEntity saved = repository.save(caseEntity);

        return CaseMapper.toResponse(saved);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public CaseResponseDTO getById(UUID id) {

        CaseEntity caseEntity = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Case not found with id: " + id));

        return CaseMapper.toResponse(caseEntity);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<CaseResponseDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(CaseMapper::toResponse)
                .toList();
    }

    @Override
    public CaseResponseDTO update(UUID id, CaseUpdateDTO dto) {

        CaseEntity caseEntity = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Case not found with id: " + id));

        CaseMapper.updateEntity(dto, caseEntity);

        CaseEntity updated = repository.save(caseEntity);

        return CaseMapper.toResponse(updated);
    }

    @Override
    public void delete(UUID id) {

        if (!repository.existsById(id)) {
            throw new NotFound("Case not found with id: " + id);
        }

        repository.deleteById(id);
    }
}