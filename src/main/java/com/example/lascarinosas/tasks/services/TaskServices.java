package com.example.lascarinosas.tasks.services;

import com.example.lascarinosas.tasks.dtos.TaskCreateDTO;
import com.example.lascarinosas.tasks.dtos.TaskResponseDTO;
import com.example.lascarinosas.tasks.dtos.TaskUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface TaskServices {

    TaskResponseDTO create(TaskCreateDTO dto);

    TaskResponseDTO getById(UUID id);

    List<TaskResponseDTO> getByCaseId(UUID caseId);

    List<TaskResponseDTO> getAll();

    TaskResponseDTO update(UUID id, TaskUpdateDTO dto);

    void delete(UUID id);
}