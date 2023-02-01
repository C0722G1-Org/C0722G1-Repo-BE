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
public class PostRestController_showAndSearchListApproval {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test list post of all field search is null
     *
     * @author NgocLV
     * @Date 01/02/2023
     */
    @Test
    public void getAllEmployee_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/posts?demandTypeSearch=null&lendTypeSearch=null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function use to test list post of all field search and in the fist time access to this page is "", page = 0
     *
     * @author NgocLV
     * @Date 01/02/2023
     */
@Test
public void getListPost_6() throws Exception {
    this.mockMvc.perform(
                    MockMvcRequestBuilders.get("/api/posts?page=0"))
            .andDo(print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("totalPages").value(2))
            .andExpect(jsonPath("totalElements").value(5))
            .andExpect(jsonPath("content[0].area").value(3000))
            .andExpect(jsonPath("content[0].codeCustomer").value("KH054"))
            .andExpect(jsonPath("content[0].landType").value("Nhà"))
            .andExpect(jsonPath("content[0].demandType").value("Mua"))
            .andExpect(jsonPath("content[0].note").value("Cần mua nhà mặt tiền"))
            .andExpect(jsonPath("content[2].area").value(4000))
            .andExpect(jsonPath("content[2].codeCustomer").value("KH055"))
            .andExpect(jsonPath("content[2].landType").value("Đất"))
            .andExpect(jsonPath("content[2].demandType").value("Bán"))
            .andExpect(jsonPath("content[2].note").value("Cần bán đất mặt tiền"));
}
    /**
     * This function use to test list post of all field search with demandType = Mua, page = 0
     *
     * @author NgocLV
     * @Date 01/02/2023
     */
    @Test
    public void getListPost_demandType_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/posts?demandTypeSearch=Mua&lendTypeSearch=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].area").value(3000))
                .andExpect(jsonPath("content[0].codeCustomer").value("KH054"))
                .andExpect(jsonPath("content[0].landType").value("Nhà"))
                .andExpect(jsonPath("content[0].demandType").value("Mua"))
                .andExpect(jsonPath("content[0].note").value("Cần mua nhà mặt tiền"))
                .andExpect(jsonPath("content[2].area").value(5000))
                .andExpect(jsonPath("content[2].codeCustomer").value("KH070"))
                .andExpect(jsonPath("content[2].landType").value("Đất"))
                .andExpect(jsonPath("content[2].demandType").value("Mua"))
                .andExpect(jsonPath("content[2].note").value("Cần mua đất ở"));
    }
    /**
     * This function use to test list post of all field search with demandType = Mua, page = 0
     *
     * @author NgocLV
     * @Date 01/02/2023
     */
    @Test
    public void getListPost_landType_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/posts?demandTypeSearch=&lendTypeSearch=Đất&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].area").value(3000))
                .andExpect(jsonPath("content[0].codeCustomer").value("KH060"))
                .andExpect(jsonPath("content[0].landType").value("Đất"))
                .andExpect(jsonPath("content[0].demandType").value("Mua"))
                .andExpect(jsonPath("content[0].note").value("Cần mua đất mặt tiền"));
    }
}
