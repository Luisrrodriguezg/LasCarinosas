package com.example.lascarinosas.people.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID caseId; // referencia al Case Service

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersonRole role;

    @Column(length = 2000)
    private String notes;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Version
    private Long version;

    public Person() {
        // Constructor vacío requerido por JPA
    }

    public Person(UUID caseId,
                  String firstName,
                  String lastName,
                  PersonRole role,
                  String notes) {
        this.caseId = caseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.notes = notes;
    }

    // Getters (idealmente sin setters públicos para caseId)
}