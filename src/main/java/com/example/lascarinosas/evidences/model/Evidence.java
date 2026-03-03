package com.example.lascarinosas.evidences.model;

import com.example.lascarinosas.caseentity.model.CaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "evidences")
public class Evidence {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private EvidenceType type;

    @Enumerated(EnumType.STRING)
    private EvidenceStatus status;

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private CaseEntity caseEntity;
}