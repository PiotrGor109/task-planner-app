package com.taskplanner.taskplannerapp.controller;


import com.taskplanner.taskplannerapp.model.TaskGroup;
import com.taskplanner.taskplannerapp.model.TaskGroupRepository;
import com.taskplanner.taskplannerapp.model.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskgroup")
public class TaskGroupController {

    private final TaskGroupRepository repository;
    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(TaskGroupController.class);

    TaskGroupController(final ApplicationEventPublisher eventPublisher, final TaskGroupRepository repository)
    {
        this.eventPublisher = eventPublisher;
        this.repository = repository;
    }


    @GetMapping
    ResponseEntity<List<TaskGroup>> readAllTaskGroups(Pageable page)
    {
        logger.info("TASK-GROUP-CONTROLLER - GET METHOD");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @PostMapping
    ResponseEntity<TaskGroup> createTaskGroup(@RequestBody TaskGroup newTaskGroup)
    {
        logger.info("TASK-GROUP-CONTROLLER - POST METHOD");
        TaskGroup newTaskGroupUnit = repository.save(newTaskGroup);
        return new ResponseEntity<>(newTaskGroup, HttpStatus.CREATED);
    }

    @DeleteMapping
    ResponseEntity<Void> deleteTaskGroup(@PathVariable int id) throws Exception {
        logger.info("TASK-GROUP-CONTROLLER - DELETE METHOD - DELETE TASKGROUP WITH ID: "+id);
        repository.delete(repository.findById(id).orElse(null));
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    ResponseEntity<TaskGroup> updateTaskGroup(@RequestBody TaskGroup newTaskGroup)
    {
        logger.info("TASKGROUP CONTROLLER - PUT METHOD - UPDATE TASK WITH id: "+ newTaskGroup.getId());
        TaskGroup newUpdatedTaskGroup = repository.save(newTaskGroup);
        return new ResponseEntity<>(newUpdatedTaskGroup, HttpStatus.OK);
    }





}
