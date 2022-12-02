package com.taskplanner.taskplannerapp.service;

import com.taskplanner.taskplannerapp.controller.TaskController;
import com.taskplanner.taskplannerapp.controller.dto.TaskGroupDto;
import com.taskplanner.taskplannerapp.controller.dto.TaskGroupWithTasksReadDto;
import com.taskplanner.taskplannerapp.controller.dto.TaskReadDto;
import com.taskplanner.taskplannerapp.controller.dto.TaskReadWithGroupDto;
import com.taskplanner.taskplannerapp.model.Task;
import com.taskplanner.taskplannerapp.model.TaskGroup;
import com.taskplanner.taskplannerapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }



    //     1. WYSWIETLANIE WSZYSTKICH TASKOW


    public List<TaskReadDto> readAllTasks()
    {
        logger.info("TASK SERVICE: GET TASK method");
        return taskRepository.findAll().stream()
                .map(task -> TaskReadDto.TaskReadDtoBuilder.aTaskReadDto()
                    .withId(task.getId())
                    .withTaskDate(task.getTaskDate())
                    .withTaskName(task.getTaskName())
                    .withDescription(task.getDescription())
                    .withIsDone(task.isDone())
                    .build())
                .collect(Collectors.toList());
    }






    //     2. WYSWIETLANIE WSZYSTKICH TASKOW WRAZ Z GRUPAMI

    public List<TaskReadWithGroupDto> readAllTasksWithGroups()
    {
        return taskRepository.findAll().stream()
                .map(task -> TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder.aTaskReadWithGroupDto()
                    .withId(task.getId())
                    .withDescription(task.getDescription())
                    .withIsDone(task.isDone())
                    .withTaskDate(task.getTaskDate())
                    .withTaskName(task.getTaskName())
                    .build())
                .collect(Collectors.toList());
    }


//        return taskGroupRepository.findAll().stream()
//                .map(taskGroup -> TaskGroupWithTasksReadDto.TaskGroupReadDtoBuilder.aTaskGroupReadDto()
//            .withId(taskGroup.getId())
//            .withTaskGroupName(taskGroup.getTaskGroupName())
//            .withTasks(taskGroup.getTasks().stream()
//                        .map(task -> TaskReadDto.TaskReadDtoBuilder.aTaskReadDto()
//            .withDescription(task.getDescription())
//            .withId(task.getId())
//            .withTaskDate(task.getTaskDate())
//            .withTaskName(task.getTaskName())
//            .withIsDone(task.isDone())
//            .build()
//                        )
//                                .collect(Collectors.toList())
//            )
//            .build()
//                ).collect(Collectors.toList());
//}

























}
