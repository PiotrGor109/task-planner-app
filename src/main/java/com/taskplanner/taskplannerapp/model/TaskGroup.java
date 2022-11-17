package com.taskplanner.taskplannerapp.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="task_group")
public class TaskGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String groupName;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taskGroupId")
    private List<Tasks> taskList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Tasks> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Tasks> taskList) {
        this.taskList = taskList;
    }


}
