package com.taskplanner.taskplannerapp.controller;

import com.taskplanner.taskplannerapp.controller.dto.TaskReadDto;
import com.taskplanner.taskplannerapp.controller.dto.TaskReadWithGroupDto;
import com.taskplanner.taskplannerapp.model.TaskRepository;
import com.taskplanner.taskplannerapp.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ApplicationEventPublisher eventPublisher;
    private final TaskService taskService;
    private final TaskRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(final ApplicationEventPublisher eventPublisher, TaskService taskService, final TaskRepository repository) {
        this.taskService = taskService;
        this.repository = repository;
        this.eventPublisher = eventPublisher;

    }




    //AD 1.
    @GetMapping
    public List<TaskReadDto> getTasks()
    {
        return taskService.readAllTasks();
    }


    //AD 2.
    @GetMapping("/withgroups")
    public List<TaskReadWithGroupDto> getTasksWithGroups()
    {
        return taskService.readAllTasksWithGroups();
    }








}
