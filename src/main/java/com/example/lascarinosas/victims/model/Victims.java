package com.example.lascarinosas.victims.model;

import com.example.lascarinosas.people.model.Person;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "victims")
@Data
public class Victims {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String deathPlace;

    @Column(length = 150)
    private String deathCause;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
}