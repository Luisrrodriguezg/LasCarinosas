package com.example.lascarinosas.propertytypes.model;

import com.example.lascarinosas.properties.model.Property;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "property_types")
@Data
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String typeName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "type")
    private List<Property> properties;
}