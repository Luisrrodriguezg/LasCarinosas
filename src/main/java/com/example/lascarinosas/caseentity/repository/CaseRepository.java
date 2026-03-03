package com.example.lascarinosas.caseentity.repository;

import com.example.lascarinosas.caseentity.model.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaseRepository extends JpaRepository<CaseEntity, UUID> {
}
