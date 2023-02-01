package com.c0722g1repobe.controller;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_updateCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateCustomer_nameCustomer_19() throws Exception{

        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("");
        customerDto.setEmailCustomer("Anh111@gmail.com");
        customerDto.setIdCardCustomer("1212121221");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/customers/update-customer/{idCustomer}", "null")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    @Test
//    public void updateCustomer_nameCustomer_24() throws Exception{
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer("Nguyễn Thúy");
//        customerDto.setEmailCustomer("Anh111@gmail.com");
//        customerDto.setIdCardCustomer("1212121221");
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/customers/update-customer/{idCustomer}")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }


}
