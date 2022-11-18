package com.taskplanner.taskplannerapp.controller;
import com.taskplanner.taskplannerapp.model.Tasks;
import com.taskplanner.taskplannerapp.model.TasksRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final ApplicationEventPublisher eventPublisher;
    private final TasksRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(TasksController.class);

    public TasksController(final ApplicationEventPublisher eventPublisher, final TasksRepository repository) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }


    @GetMapping
    ResponseEntity<List<Tasks>> readAllTasks(Pageable page)
    {
        logger.info("TASKS CONTROLLER - GET METHOD");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @PostMapping
    ResponseEntity<Tasks> createTask(@RequestBody Tasks newTasks)
    {
        logger.info("TASK CONTROLLER - POST METHOD");
        Tasks newTask = repository.save(newTasks);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @DeleteMapping
    ResponseEntity<Void> deleteTask(@PathVariable int id) throws Exception {
        logger.info("TASK CONTROLLER - DELETE METHOD - DELETE TASK WITH ID: "+id);
        repository.delete(repository.findById(id).orElse(null));
        return ResponseEntity.noContent().build();
    }






}
