package com.example.lascarinosas.properties.repository;

import com.example.lascarinosas.families.model.Family;
import com.example.lascarinosas.properties.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertiesRepository extends JpaRepository<Property,Long> {

}
