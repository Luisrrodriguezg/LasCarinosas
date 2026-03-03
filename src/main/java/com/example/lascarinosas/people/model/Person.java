package com.example.lascarinosas.people.model;

import com.example.lascarinosas.caseentity.model.CaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @Column(length = 2000)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private CaseEntity caseEntity;
}