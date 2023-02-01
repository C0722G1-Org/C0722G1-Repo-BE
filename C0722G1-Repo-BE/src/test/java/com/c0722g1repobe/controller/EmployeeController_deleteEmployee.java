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
public class


EmployeeController_deleteEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteEmployee_id_25() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/employees/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_id_26() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/employees/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_id_27() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/employees/27"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_id_28() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/employees/4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
