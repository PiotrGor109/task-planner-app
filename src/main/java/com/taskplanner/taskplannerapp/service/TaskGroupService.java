package com.taskplanner.taskplannerapp.service;

import com.taskplanner.taskplannerapp.controller.TaskGroupController;
import com.taskplanner.taskplannerapp.controller.dto.TaskGroupDto;
import com.taskplanner.taskplannerapp.controller.dto.TaskGroupWithTasksReadDto;
import com.taskplanner.taskplannerapp.controller.dto.TaskReadDto;
import com.taskplanner.taskplannerapp.model.TaskGroup;
import com.taskplanner.taskplannerapp.model.TaskGroupRepository;
import com.taskplanner.taskplannerapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {


    private final TaskGroupRepository taskGroupRepository;
    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskGroupController.class);




    public TaskGroupService(TaskGroupRepository taskGroupRepository, TaskRepository taskRepository) {
        this.taskGroupRepository = taskGroupRepository;
        this.taskRepository = taskRepository;
    }



       //  1. WYSWIETLANIE WSZYSTKICH GRUP TASKOW

    public List<TaskGroupDto> readAllTaskGroups()
    {
        logger.info("TASKGROUP SERVICE: GET TASKGROUPS method");
        return mapToTaskGroupDtos(taskGroupRepository.findAll());
    }


    public static List<TaskGroupDto> mapToTaskGroupDtos(List<TaskGroup> readAllTaskGroups) {
        return  readAllTaskGroups.stream()
                .map(taskGroup -> mapToTaskGroupDto(taskGroup))
                .collect(Collectors.toList());
    }

    private static TaskGroupDto mapToTaskGroupDto(TaskGroup taskGroup) {
        return new TaskGroupDto(taskGroup.getId(), taskGroup.getTaskGroupName());
    }









       //  2. WYSWIETLANIE WSZYSTKICH GRUP TASKOW RAZEM Z TASKAMI


    public List<TaskGroupWithTasksReadDto> readAllGroupsWithTasks()
    {
        logger.info("TASKGROUP SERVICE: GET TASKGROUPSWITHTASKS method");
        return taskGroupRepository.findAll().stream()
                .map(taskGroup -> TaskGroupWithTasksReadDto.TaskGroupReadDtoBuilder.aTaskGroupReadDto()
                    .withId(taskGroup.getId())
                    .withTaskGroupName(taskGroup.getTaskGroupName())
                    .withTasks(taskGroup.getTasks().stream()
                        .map(task -> TaskReadDto.TaskReadDtoBuilder.aTaskReadDto()
                            .withDescription(task.getDescription())
                            .withId(task.getId())
                            .withTaskDate(task.getTaskDate())
                            .withTaskName(task.getTaskName())
                            .withIsDone(task.isDone())
                            .build()
                        )
                        .collect(Collectors.toList())
                    )
                    .build()
                ).collect(Collectors.toList());
    }




}
