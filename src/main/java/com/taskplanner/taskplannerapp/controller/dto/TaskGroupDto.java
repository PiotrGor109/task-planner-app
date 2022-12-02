package com.taskplanner.taskplannerapp.controller.dto;

public class TaskGroupDto {

    private int id;
    private String taskGroupName;


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


    public static final class TaskGroupDtoBuilder {
        private int id;
        private String taskGroupName;


        public TaskGroupDtoBuilder() {
        }

        public static TaskGroupDto.TaskGroupDtoBuilder aTaskGroupDto() {
            return new TaskGroupDto.TaskGroupDtoBuilder();
        }

        public TaskGroupDto.TaskGroupDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public TaskGroupDto.TaskGroupDtoBuilder withTaskGroupName(String taskGroupName) {
            this.taskGroupName = taskGroupName;
            return this;
        }



        public TaskGroupDto build() {
            TaskGroupDto TaskGroupDto = new TaskGroupDto();
            TaskGroupDto.taskGroupName = this.taskGroupName;
            TaskGroupDto.id=this.id;
            return TaskGroupDto;
        }
    }









}
