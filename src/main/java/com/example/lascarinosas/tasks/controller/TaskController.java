package com.example.lascarinosas.tasks.controller;

import com.example.lascarinosas.tasks.dtos.TaskCreateDTO;
import com.example.lascarinosas.tasks.dtos.TaskResponseDTO;
import com.example.lascarinosas.tasks.dtos.TaskUpdateDTO;
import com.example.lascarinosas.tasks.services.TaskServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServices service;

    public TaskController(TaskServices service) {
        this.service = service;
    }

    @PostMapping
    public TaskResponseDTO create(@RequestBody @Valid TaskCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<TaskResponseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/case/{caseId}")
    public List<TaskResponseDTO> getByCaseId(@PathVariable UUID caseId) {
        return service.getByCaseId(caseId);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO update(@PathVariable UUID id,
                                  @RequestBody @Valid TaskUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}