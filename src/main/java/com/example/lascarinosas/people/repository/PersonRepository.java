package com.example.lascarinosas.people.repository;

import com.example.lascarinosas.people.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    List<Person> findByCaseId(UUID caseId);
}
