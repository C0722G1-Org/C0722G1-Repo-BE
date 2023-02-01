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
public class CustomerRestController_getListCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListCustomer_5() throws Exception{

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/customer/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListCustomer_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/list?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].codeCustomer").value("B01"))
                .andExpect(jsonPath("content[0].nameCustomer").value("Nguyễn Thị Hào"))
                .andExpect(jsonPath("content[0].addressCustomer").value("Đà nẵng"))
                .andExpect(jsonPath("content[0].phoneCustomer1").value("0945423362"))
                .andExpect(jsonPath("content[0].phoneCustomer2").value("0845423351"))
                .andExpect(jsonPath("content[0].approvalCustomer").value(0))
                .andExpect(jsonPath("content[4].nameCustomer").value("Hoàng Trần Nhi Nhi"))
                .andExpect(jsonPath("content[4].addressCustomer").value("Hà Nội"))
                .andExpect(jsonPath("content[4].phoneCustomer1").value("0945412345"))
                .andExpect(jsonPath("content[4].phoneCustomer2").value("0845454321"))
                .andExpect(jsonPath("content[4].approvalCustomer").value(0));

    }


}
