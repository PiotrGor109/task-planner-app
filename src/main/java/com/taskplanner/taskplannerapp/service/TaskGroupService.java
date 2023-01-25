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



       //  1. SHOWING GROUPS
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

    private static TaskGroupDto mapToTaskGroupDto(TaskGroup taskGroup)
    {
        return TaskGroupDto.TaskGroupDtoBuilder.aTaskGroupDto()
                .withId(taskGroup.getId())
                .withTaskGroupName(taskGroup.getTaskGroupName())
                .build();
    }




       //  2. SHOWING GROUPS WITH TASKS
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
                            .withDone(task.getDone())
                            .build()
                        )
                        .collect(Collectors.toList())
                    )
                    .build()
                ).collect(Collectors.toList());
    }


    //  3. ADDING GROUPS
    public TaskGroup addTaskGroup(TaskGroupDto taskGroup) {
        logger.info("TASKGROUP SERVICE: POST - ADDTASK GROUP method");
        TaskGroup newTaskGroup = new TaskGroup();
        newTaskGroup.setId(taskGroup.getId());
        newTaskGroup.setTaskGroupName(taskGroup.getTaskGroupName());
        return taskGroupRepository.save(newTaskGroup);
    }



    //  4. DELETING GROUPS
    public void deleteTaskGroup(int id) {
        logger.info("TASKGROUP DELETE: DELETE - TASKGROUP method");
        TaskGroup taskGroupToDelete = taskGroupRepository.findById(id).orElseThrow(null);
        taskGroupRepository.delete(taskGroupToDelete);
    }

    //  5. EDITING GROUPS
    public TaskGroup editTaskGroup(TaskGroup taskGroup) {
        logger.info("TASKGROUP PUT: PUT - TASKGROUP method");
        return taskGroupRepository.save(taskGroup);
    }
}


