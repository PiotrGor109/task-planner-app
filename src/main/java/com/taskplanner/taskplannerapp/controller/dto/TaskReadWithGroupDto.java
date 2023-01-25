package com.taskplanner.taskplannerapp.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taskplanner.taskplannerapp.controller.TaskController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;

public class TaskReadWithGroupDto {

    private int id;
    private String taskName;
    private String description;
    private boolean done;
    private LocalDateTime taskDate;
    private TaskGroupDto group;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);


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

    public TaskGroupDto getGroup() {
        return group;
    }

    public void setGroup(TaskGroupDto group) {
        this.group = group;
    }



    public static final class TaskReadWithGroupDtoBuilder {
        private int id;
        private String taskName;
        private String description;
        private boolean done;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime taskDate;
        private TaskGroupDto group;


        public TaskReadWithGroupDtoBuilder() {
        }

        public static TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder aTaskReadWithGroupDto() {
            return new TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder();
        }

        public TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder withDone(boolean done) {
            this.done = done;
            return this;
        }

        public TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder withTaskDate(LocalDateTime taskDate) {
            this.taskDate = taskDate;
            return this;
        }

        public TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder withTaskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }


        public TaskReadWithGroupDto.TaskReadWithGroupDtoBuilder withGroup(int id, String taskGroupName) {
            TaskGroupDto taskGroupDto = new TaskGroupDto();
            taskGroupDto.setId(id);
            taskGroupDto.setTaskGroupName(taskGroupName);
            this.group = taskGroupDto;
            return this;
        }


        public TaskReadWithGroupDto build() {
            TaskReadWithGroupDto TaskReadWithGroupDto = new TaskReadWithGroupDto();
            TaskReadWithGroupDto.taskName = this.taskName;
            TaskReadWithGroupDto.id = this.id;
            TaskReadWithGroupDto.description = this.description;
            TaskReadWithGroupDto.done = this.done;
            TaskReadWithGroupDto.taskDate = this.taskDate;
            TaskReadWithGroupDto.group=this.group;
            return TaskReadWithGroupDto;
        }
    }
}
