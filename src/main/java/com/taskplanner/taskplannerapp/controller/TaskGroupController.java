package com.taskplanner.taskplannerapp.controller;


import com.taskplanner.taskplannerapp.model.TaskGroup;
import com.taskplanner.taskplannerapp.model.TaskGroupRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taskgroup")
public class TaskGroupController {

    private final TaskGroupRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    TaskGroupController(final ApplicationEventPublisher eventPublisher, final TaskGroupRepository repository)
    {
        this.eventPublisher = eventPublisher;
        this.repository = repository;
    }



    @GetMapping
    ResponseEntity<List<TaskGroup>> readAllTaskGroups(Pageable page)
    {
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }


}
