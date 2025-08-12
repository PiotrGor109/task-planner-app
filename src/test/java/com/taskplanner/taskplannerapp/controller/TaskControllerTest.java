package com.taskplanner.taskplannerapp.controller;

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


@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getTasksWithGroupsMyTest() throws Exception {

        //given
        //when
//        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/2022-12-17"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is(200))
//                //.andExpect(MockMvcResultMatchers.jsonPath("$.taskName", Matchers.is("Creating models")));
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].taskName").value("Creating models"))
//                .andReturn();

        //  TaskReadWithGroupDto ObjectToTest = createMock();


//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/tasks/2022-12-17"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is(200))
//                //.andExpect(MockMvcResultMatchers.jsonPath("$.taskName", Matchers.is("Creating models")));
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].taskName").value("Creating models"))
//                .andReturn();

        //then
//        TaskReadWithGroupDto task = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), TaskReadWithGroupDto.class);
//        assertThat(task.getId()).isNotNull();


        //assertThat(ObjectToTest.getId()).isNotNull();


//
//    }
//    private TaskReadWithGroupDto createMock()
//    {
//        TaskReadWithGroupDto mock = Mockito.mock(TaskReadWithGroupDto.class);
//        mock.getId(0) = 1;
//        mock.produktObiekt1 = "BBB";
//        mock.cenaObiekt1 = 1;
//        mock.cenaObiekt2 = 51;
//        return mock;
//    }
    }

}