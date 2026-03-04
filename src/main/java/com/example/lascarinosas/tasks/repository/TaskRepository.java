package com.example.lascarinosas.tasks.repository;

import com.example.lascarinosas.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByCaseEntityId(UUID caseId);
}
