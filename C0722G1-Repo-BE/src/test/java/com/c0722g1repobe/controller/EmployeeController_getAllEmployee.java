package com.c0722g1repobe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_getAllEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllEmployee_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employees/employee-list?codeSearch=null&nameSearch=null&emailSearch=null&nameDivisionSearch=null&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getAllEmployee_codeSearch_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employees/employee-list?codeSearch=null&nameSearch=null&emailSearch=null&nameDivisionSearch=null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
