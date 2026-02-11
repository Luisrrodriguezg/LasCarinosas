package com.example.lascarinosas.families.model;


import com.example.lascarinosas.people.model.Person;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "families")
@Data
public class  Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String lastName;

    //Varias personas pueden ser parte de una familia
    @OneToMany(mappedBy = "family")
    private List<Person> members;
}

