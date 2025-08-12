package com.taskplanner.taskplannerapp.service;

import com.taskplanner.taskplannerapp.controller.dto.TaskGroupDto;
import com.taskplanner.taskplannerapp.model.TaskGroup;
import com.taskplanner.taskplannerapp.model.TaskGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskplanner.taskplannerapp.controller.dto.TaskReadDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskplanner.taskplannerapp.controller.dto.TaskReadDto;

import com.taskplanner.taskplannerapp.controller.dto.TaskReadWithGroupDto;
import com.taskplanner.taskplannerapp.service.TaskService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskGroupServiceTest {

    @Autowired
    private TaskGroupService taskGroupService;


    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Test
    void readAllTaskGroups() {

        //given
        TaskGroup taskGrouper = new TaskGroup();
        taskGrouper.setTaskGroupName("MOJA TESTOWA GRUPA");
        taskGroupRepository.save(taskGrouper);



        //when
        List<TaskGroupDto> taskGroups = taskGroupService.readAllTaskGroups();

        //then
        assertThat(taskGroups).isNotNull();
        assertThat(taskGroups.get(0).getId()).isEqualTo(1);
        assertThat(taskGroups.get(taskGroups.size()-1).getTaskGroupName()).isEqualTo("MOJA TESTOWA GRUPA");

    }
}