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
public class PostRestController_getPostListByUserNameAccount {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getPostListByUserNameAccount_userNameAccount_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/post/{userNameAccount}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPostListByUserNameAccount_userNameAccount_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/post/{userNameAccount}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPostListByUserNameAccount_userNameAccount_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/post/{userNameAccount}", "khachhang123"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(17))
                .andExpect(jsonPath("area").value("Khu đô thị condotel Đà Nẵng"))
                .andExpect(jsonPath("demandType.idDemandType").value(1))
                .andExpect(jsonPath("landType.idLandType").value(3));

    }
    @Test
    public void getPostListByUserNameAccount_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/post/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPostListByUserNameAccount_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/post/?page=1", "null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].area").value("FLC Thanh Hóa"))
                .andExpect(jsonPath("content[0].demandType.idDemandType").value(2))
                .andExpect(jsonPath("content[0].landType.idLandType").value(2))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].area").value("Vinpearl Nam Hội An"))
                .andExpect(jsonPath("content[4].demandType.idDemandType").value(1))
                .andExpect(jsonPath("content[4].landType.idLandType").value(1));
    }
}
