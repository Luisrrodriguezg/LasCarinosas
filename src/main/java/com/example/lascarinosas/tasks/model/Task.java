package com.example.lascarinosas.tasks.model;

import com.example.lascarinosas.caseentity.model.CaseEntity;
import com.example.lascarinosas.people.model.Person;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private CaseEntity caseEntity;

    @ManyToOne
    @JoinColumn(name = "assigned_person_id")
    private Person assignedTo;
}