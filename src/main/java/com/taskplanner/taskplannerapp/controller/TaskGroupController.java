package com.taskplanner.taskplannerapp.controller;

import com.taskplanner.taskplannerapp.controller.dto.TaskGroupDto;
import com.taskplanner.taskplannerapp.controller.dto.TaskGroupWithTasksReadDto;
import com.taskplanner.taskplannerapp.model.TaskGroup;
import com.taskplanner.taskplannerapp.service.TaskGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/taskgroups")
public class TaskGroupController {


    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private TaskGroupService taskGroupService;
    public TaskGroupController(TaskGroupService taskGroupService) {
        this.taskGroupService = taskGroupService;
    }


  //AD 1  - SHOWING GROUPS
    @GetMapping
    public List<TaskGroupDto> getTaskGroups()
    {
        logger.info("getTaskGroups - Method - TaskGroupController");
        return taskGroupService.readAllTaskGroups();
    }


    //AD 2 -SHOWING GROUPS WITH TASKS
    @GetMapping("/withtasks")
    public List<TaskGroupWithTasksReadDto> readAllGroups() {
        return taskGroupService.readAllGroupsWithTasks();
    }



    //AD 3 - ADDING GROUPS
    @PostMapping()
    public TaskGroup addTaskGroup(@RequestBody TaskGroupDto taskGroupDto)
    {
        return taskGroupService.addTaskGroup(taskGroupDto);
    }


    //AD 4 - DELETEING GROUPS
    @DeleteMapping("/{id}")
    public void deleteTaskGroup(@PathVariable int id)
    {
        taskGroupService.deleteTaskGroup(id);
    }


    //AD 5 - EDITING GROUPS
    @PutMapping()
    public void editTaskGroup(@RequestBody TaskGroup taskGroup)
    {
        taskGroupService.editTaskGroup(taskGroup);

    }
}
