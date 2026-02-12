package com.example.lascarinosas.people.model;
import com.example.lascarinosas.families.model.Family;
import com.example.lascarinosas.properties.model.Property;
import com.example.lascarinosas.victims.model.Victims;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "people")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(length = 120)
    private String occupation;

    // Many people belong to one family
    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    // One person may own many properties
    @OneToMany(mappedBy = "owner")
    private List<Property> properties;

    // One-to-one victim relationship
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Victims victim;
}
