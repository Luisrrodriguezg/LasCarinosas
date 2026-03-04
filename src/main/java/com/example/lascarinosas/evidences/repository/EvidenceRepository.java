package com.example.lascarinosas.evidences.repository;

import com.example.lascarinosas.evidences.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;

public interface EvidenceRepository extends JpaRepository<Evidence, UUID> {
    List<Evidence> findByCaseEntityId(UUID caseId);
}
