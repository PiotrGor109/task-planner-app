package com.taskplanner.taskplannerapp.controller.dto;

public class TaskGroupDto {

    int id;
    String taskGroupName;

    public TaskGroupDto(int id, String taskGroupName)
    {
        this.id=id;
        this.taskGroupName=taskGroupName;
    }

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


}
