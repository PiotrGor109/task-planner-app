package com.taskplanner.taskplannerapp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tasks {


    @Id
    private int id;
    private String taskName;
    private String description;
    @ManyToOne
    @JoinColumn(name="task_group")
    private TaskGroup taskGroup;
}
