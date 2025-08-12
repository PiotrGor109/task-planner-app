package com.taskplanner.taskplannerapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class TaskGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTaskGroups_basicMethod() throws Exception {

        //given


        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/taskgroups"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", is(5)))
                .andReturn();


        //then

    }
}