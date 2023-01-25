package com.taskplanner.taskplannerapp.controller;

import com.taskplanner.taskplannerapp.controller.dto.TaskReadWithGroupDto;
import com.taskplanner.taskplannerapp.model.Task;
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


    //AD 1. SHOWING TASK
    @GetMapping()
    public List<TaskReadWithGroupDto> getTasksWithGroups()
    {
        return taskService.readAllTasksWithGroups();
    }


    //AD 2. ADDING TASK
    @PostMapping()
    public Task addTask(@RequestBody TaskReadWithGroupDto taskReadDto)
    {
        return taskService.addTask(taskReadDto);
    }


    //AD 3. DELETING TASK
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id)
    {
       taskService.deleteTask(id);
    }


    //AD 4. EDITING TASK
    @PutMapping()
    public void editTask(@RequestBody TaskReadWithGroupDto taskReadDto)
    {
        taskService.editTask(taskReadDto);
    }


    //AD 5. SHOWING BY DATE
    @GetMapping("/{task_date}")
    public List<TaskReadWithGroupDto> getTasksWithDate(@PathVariable String task_date)
        {
            return taskService.readAllTasksWithDate(task_date);
        }
}
