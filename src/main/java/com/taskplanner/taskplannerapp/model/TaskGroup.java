package com.taskplanner.taskplannerapp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TaskGroup {

    @Id
    private int id;
    private String groupName;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Tasks> taskList;
}
