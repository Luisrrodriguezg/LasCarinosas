package com.example.lascarinosas.people.repository;

import com.example.lascarinosas.people.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
