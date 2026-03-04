package com.example.lascarinosas.tasks.services;

import com.example.lascarinosas.caseentity.model.CaseEntity;
import com.example.lascarinosas.caseentity.repository.CaseRepository;
import com.example.lascarinosas.common.exception.NotFound;
import com.example.lascarinosas.people.model.Person;
import com.example.lascarinosas.people.repository.PersonRepository;
import com.example.lascarinosas.tasks.dtos.TaskCreateDTO;
import com.example.lascarinosas.tasks.dtos.TaskResponseDTO;
import com.example.lascarinosas.tasks.dtos.TaskUpdateDTO;
import com.example.lascarinosas.tasks.mapper.TaskMapper;
import com.example.lascarinosas.tasks.model.Task;
import com.example.lascarinosas.tasks.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TaskServicesImpl implements TaskServices {

    private final TaskRepository repository;
    private final CaseRepository caseRepository;
    private final PersonRepository personRepository;

    public TaskServicesImpl(TaskRepository repository,
                            CaseRepository caseRepository,
                            PersonRepository personRepository) {
        this.repository = repository;
        this.caseRepository = caseRepository;
        this.personRepository = personRepository;
    }

    @Override
    public TaskResponseDTO create(TaskCreateDTO dto) {

        CaseEntity caseEntity = caseRepository.findById(dto.caseId())
                .orElseThrow(() ->
                        new NotFound("Case not found with id: " + dto.caseId()));

        Task task = TaskMapper.toEntity(dto);
        task.setCaseEntity(caseEntity);

        if (dto.assignedPersonId() != null) {
            Person person = personRepository.findById(dto.assignedPersonId())
                    .orElseThrow(() ->
                            new NotFound("Person not found with id: " + dto.assignedPersonId()));

            // Validación importante: la persona debe pertenecer al mismo case
            if (!person.getCaseEntity().getId().equals(dto.caseId())) {
                throw new IllegalArgumentException("Person does not belong to this case");
            }

            task.setAssignedTo(person);
        }

        return TaskMapper.toResponse(repository.save(task));
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public TaskResponseDTO getById(UUID id) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Task not found with id: " + id));

        return TaskMapper.toResponse(task);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TaskResponseDTO> getByCaseId(UUID caseId) {

        if (!caseRepository.existsById(caseId)) {
            throw new NotFound("Case not found with id: " + caseId);
        }

        return repository.findByCaseEntityId(caseId)
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TaskResponseDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponseDTO update(UUID id, TaskUpdateDTO dto) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new NotFound("Task not found with id: " + id));

        TaskMapper.updateEntity(dto, task);

        if (dto.assignedPersonId() != null) {

            Person person = personRepository.findById(dto.assignedPersonId())
                    .orElseThrow(() ->
                            new NotFound("Person not found with id: " + dto.assignedPersonId()));

            if (!person.getCaseEntity().getId()
                    .equals(task.getCaseEntity().getId())) {
                throw new IllegalArgumentException("Person does not belong to this case");
            }

            task.setAssignedTo(person);
        } else {
            task.setAssignedTo(null);
        }

        return TaskMapper.toResponse(repository.save(task));
    }

    @Override
    public void delete(UUID id) {

        if (!repository.existsById(id)) {
            throw new NotFound("Task not found with id: " + id);
        }

        repository.deleteById(id);
    }
}