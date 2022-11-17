package com.taskplanner.taskplannerapp.controller;


import com.taskplanner.taskplannerapp.model.Tasks;
import com.taskplanner.taskplannerapp.model.TasksRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {


    private final TasksRepository repository;

    public TasksController(final TasksRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    ResponseEntity<List<Tasks>> readAllTasks(Pageable page)
    {
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

}
