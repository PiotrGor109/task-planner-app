package com.taskplanner.taskplannerapp.controller.dto;

import java.util.List;

public class TaskGroupWithTasksReadDto {

    private int id;
    private String taskGroupName;
    private List<TaskReadDto> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskGroupName() {
        return taskGroupName;
    }

    public void setTaskGroupName(String taskGroupName) {
        this.taskGroupName = taskGroupName;
    }

    public List<TaskReadDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskReadDto> tasks) {
        this.tasks = tasks;
    }


    public static final class TaskGroupReadDtoBuilder {
        private int id;
        private String taskGroupName;
        private List<TaskReadDto> tasks;

        public TaskGroupReadDtoBuilder() {
        }

        public static TaskGroupReadDtoBuilder aTaskGroupReadDto() {
            return new TaskGroupReadDtoBuilder();
        }

        public TaskGroupReadDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public TaskGroupReadDtoBuilder withTaskGroupName(String taskGroupName) {
            this.taskGroupName = taskGroupName;
            return this;
        }


        public TaskGroupReadDtoBuilder withTasks(List<TaskReadDto> tasks) {
            this.tasks = tasks;
            return this;
        }

        public TaskGroupWithTasksReadDto build() {
            TaskGroupWithTasksReadDto TaskGroupWithTasksReadDto = new TaskGroupWithTasksReadDto();
            TaskGroupWithTasksReadDto.taskGroupName = this.taskGroupName;
            TaskGroupWithTasksReadDto.tasks = this.tasks;
            TaskGroupWithTasksReadDto.id = this.id;
            return TaskGroupWithTasksReadDto;
        }
    }
}
