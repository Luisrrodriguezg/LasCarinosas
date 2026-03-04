package com.example.lascarinosas.tasks.mapper;

import com.example.lascarinosas.tasks.dtos.TaskCreateDTO;
import com.example.lascarinosas.tasks.dtos.TaskResponseDTO;
import com.example.lascarinosas.tasks.dtos.TaskUpdateDTO;
import com.example.lascarinosas.tasks.model.Task;

public class TaskMapper {

    private TaskMapper(){}

    public static TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getCaseEntity().getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getAssignedTo() != null ? task.getAssignedTo().getId() : null
        );
    }

    public static Task toEntity(TaskCreateDTO dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());
        return task;
    }

    public static void updateEntity(TaskUpdateDTO dto, Task task) {
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setPriority(dto.priority());
    }


}