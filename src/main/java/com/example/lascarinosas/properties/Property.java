package com.example.lascarinosas.properties;


import com.example.lascarinosas.people.model.Person;
import com.example.lascarinosas.propertytypes.PropertyType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "properties")
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String location;

    private BigDecimal currentValue;

    private LocalDate acquisitionDate;

    // Many properties belong to one person
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    // Many properties can have one type
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PropertyType type;
}
