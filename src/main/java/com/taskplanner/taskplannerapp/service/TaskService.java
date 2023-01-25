package com.taskplanner.taskplannerapp.service;

import com.taskplanner.taskplannerapp.controller.TaskController;
import com.taskplanner.taskplannerapp.controller.dto.*;
import com.taskplanner.taskplannerapp.model.Task;
import com.taskplanner.taskplannerapp.model.TaskGroup;
import com.taskplanner.taskplannerapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }



//      1. SHOWING TASKS WITH GROUPS
    public List<TaskReadWithGroupDto> readAllTasksWithGroups()
    {
        logger.info("TASK SERVICE: GET TASK WITH GROUPS method");
        return taskRepository.findAll().stream()
                .map(task-> TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder.aTaskReadWithGroupDto()
                        .withId(task.getId())
                        .withDescription(task.getDescription())
                        .withDone(task.getDone())
                        .withTaskDate(task.getTaskDate())
                        .withTaskName(task.getTaskName())
                        .withGroup(task.getGroup().getId(), task.getGroup().getTaskGroupName())
                        .build())
                .collect(Collectors.toList());
    }

//     2. ADDING TASK
    public Task addTask(TaskReadWithGroupDto taskReadDto) {
        logger.info("TASK SERVICE: ADD TASK method");
        logger.info(taskReadDto.getTaskName());
        Task newTask = new Task();
        TaskGroup newTaskGroupAssign = new TaskGroup();

        newTaskGroupAssign.setTaskGroupName(taskReadDto.getGroup().getTaskGroupName());
        newTaskGroupAssign.setId(taskReadDto.getGroup().getId());
        newTask.setTaskName(taskReadDto.getTaskName());
        newTask.setTaskDate(taskReadDto.getTaskDate());
        newTask.setDescription(taskReadDto.getDescription());
        newTask.setGroup(newTaskGroupAssign);
        newTask.setDone(taskReadDto.getDone());
        return taskRepository.save(newTask);
    }


//     3. DELETING TASK
    public void deleteTask(int id) {
        logger.info("TASK SERVICE: DELETE TASK method");
        Task taskToDelete = taskRepository.findById(id).orElseThrow(null);
        taskRepository.delete(taskToDelete);
    }


//     4. EDYTOWANIE TASKOW
public Task editTask(TaskReadWithGroupDto taskReadDto) {
    logger.info("TASK SERVICE: EDIT TASK method");

    logger.info(taskReadDto.getTaskName());
    Task newTask = new Task();
    TaskGroup newTaskGroupAssign = new TaskGroup();

    newTaskGroupAssign.setTaskGroupName(taskReadDto.getGroup().getTaskGroupName());
    newTaskGroupAssign.setId(taskReadDto.getGroup().getId());
    newTask.setTaskName(taskReadDto.getTaskName());
    newTask.setTaskDate(taskReadDto.getTaskDate());
    newTask.setDescription(taskReadDto.getDescription());
    newTask.setGroup(newTaskGroupAssign);
    newTask.setDone(taskReadDto.getDone());
    newTask.setId(taskReadDto.getId());
    logger.info("AAAAAAAAAAAAAAAAAAA: "+ newTask.getId());
    logger.info("GROUPA: "+newTask.getGroup().getId() +" "+newTask.getGroup().getTaskGroupName());
    return taskRepository.save(newTask);
}

    public List<TaskReadWithGroupDto> readAllTasksWithDate(String task_date)
    {
        logger.info("TASK SERVICE: GET TASK WITH DATE method");
        logger.info(task_date);
        return taskRepository.findByTaskDate(task_date).stream()
                .map(task-> TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder.aTaskReadWithGroupDto()
                        .withId(task.getId())
                        .withDescription(task.getDescription())
                        .withDone(task.getDone())
                        .withTaskDate(task.getTaskDate())
                        .withTaskName(task.getTaskName())
                        .withGroup(task.getGroup().getId(), task.getGroup().getTaskGroupName())
                        .build())
                .collect(Collectors.toList());
    }


















    //      WYSWIETLANIE WSZYSTKICH TASKOW bez grup
//    public List<TaskReadDto> readAllTasks()
//    {
//        logger.info("TASK SERVICE: GET TASK method");
//        return taskRepository.findAll().stream()
//                .map(task -> TaskReadDto.TaskReadDtoBuilder.aTaskReadDto()
//                    .withId(task.getId())
//                    .withTaskDate(task.getTaskDate())
//                    .withTaskName(task.getTaskName())
//                    .withDescription(task.getDescription())
//                    .withIsDone(task.isDone())
//                    .build())
//                .collect(Collectors.toList());
//    }


}
