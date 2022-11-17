package com.taskplanner.taskplannerapp.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
public class Tasks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String taskName;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskDate;
   // @JsonIgnore
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="task_group_id")
    private TaskGroup taskGroupId;


    public LocalDateTime getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDateTime taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskGroupId(TaskGroup taskGroupId) {
        this.taskGroupId = taskGroupId;
    }

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

    public TaskGroup getTaskGroupId() {
        return taskGroupId;
    }

    public void setTaskGroup(TaskGroup taskGroupId) {
        this.taskGroupId = taskGroupId;
    }
}
