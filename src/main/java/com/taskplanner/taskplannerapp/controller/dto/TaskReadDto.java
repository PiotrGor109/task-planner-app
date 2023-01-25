package com.taskplanner.taskplannerapp.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class TaskReadDto {

    private int id;
    private String taskName;
    private String description;
    private boolean done;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDateTime taskDate) {
        this.taskDate = taskDate;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public static final class TaskReadDtoBuilder {
        private int id;
        private String taskName;
        private String description;
        private boolean done;
        private LocalDateTime taskDate;

        public TaskReadDtoBuilder() {
        }

        public static TaskReadDto.TaskReadDtoBuilder aTaskReadDto() {
            return new TaskReadDto.TaskReadDtoBuilder();
        }

        public TaskReadDto.TaskReadDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public TaskReadDto.TaskReadDtoBuilder withDone(boolean done) {
            this.done = done;
            return this;
        }

        public TaskReadDto.TaskReadDtoBuilder withTaskDate(LocalDateTime taskDate) {
            this.taskDate = taskDate;
            return this;
        }

        public TaskReadDto.TaskReadDtoBuilder withTaskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public TaskReadDto.TaskReadDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TaskReadDto build() {
            TaskReadDto TaskReadDto = new TaskReadDto();
            TaskReadDto.taskName = this.taskName;
            TaskReadDto.id = this.id;
            TaskReadDto.description = this.description;
            TaskReadDto.done = this.done;
            TaskReadDto.taskDate = this.taskDate;
            return TaskReadDto;
        }
    }
}
