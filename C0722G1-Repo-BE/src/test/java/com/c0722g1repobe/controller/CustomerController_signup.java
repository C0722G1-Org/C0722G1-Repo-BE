package com.c0722g1repobe.controller;


import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.entity.account.Account;
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
public class CustomerController_signup {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

////    @Test
////    public void createCustomer_name_18() throws Exception {
////
////        CustomerDto customerDto = new CustomerDto();
////        customerDto.setNameCustomer("Trinh Minh Duc2");
////        customerDto.setDateOfBirth("18/09/2011");
////        customerDto.setGenderCustomer(1);
////        customerDto.setIdCardCustomer("123456789");
////        customerDto.setEmailCustomer("duc123444@gmail");
////        customerDto.setAddressCustomer("danang");
////        customerDto.setPhoneCustomer1("123456789");
////        customerDto.setPhoneCustomer2("123456789");
////
////        Account account = new Account();
////        account.setUsernameAccount("duc13333");
////        account.setEncryptPassword("123456555");
////        customerDto.setAccount(account);
////
////
////        this.mockMvc
////                .perform(MockMvcRequestBuilders
////                        .post("/api/customer/signup")
////                        .content(this.objectMapper.writeValueAsString(customerDto))
////                        .contentType(MediaType.APPLICATION_JSON_VALUE))
////                .andDo(print())
////                .andExpect(status().is2xxSuccessful());
////    }
//
//    @Test
//    public void createCustomer_name_13() throws Exception {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer();
//        customerDto.setDateOfBirth();
//        customerDto.setGenderCustomer();
//        customerDto.setIdCardCustomer();
//        customerDto.setEmailCustomer();
//        customerDto.setAddressCustomer();
//        customerDto.setPhoneCustomer1();
//        customerDto.setPhoneCustomer2();
//
//        Account account = new Account();
//        account.setUsernameAccount();
//        account.setEncryptPassword();
//        customerDto.setAccount(account);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/customer/signup")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void createCustomer_name_14() throws Exception {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer("");
//        customerDto.setDateOfBirth("");
//        customerDto.setGenderCustomer();
//        customerDto.setIdCardCustomer("");
//        customerDto.setEmailCustomer("");
//        customerDto.setAddressCustomer("");
//        customerDto.setPhoneCustomer1("");
//        customerDto.setPhoneCustomer2("");
//
//        Account account = new Account();
//        account.setUsernameAccount("");
//        account.setEncryptPassword("");
//        customerDto.setAccount(account);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/customer/signup")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    @Test
//    public void createCustomer_name_15() throws Exception {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer("Trinh Minh Duc2");
//        customerDto.setDateOfBirth("18/09/2011");
//        customerDto.setGenderCustomer(1);
//        customerDto.setIdCardCustomer("12345678999999");
//        customerDto.setEmailCustomer("214323423");
//        customerDto.setAddressCustomer("danang");
//        customerDto.setPhoneCustomer1("123456789999");
//        customerDto.setPhoneCustomer2("12345678999999");
//
//        Account account = new Account();
//        account.setUsernameAccount("duc13333");
//        account.setEncryptPassword("123456555");
//        customerDto.setAccount(account);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/customer/signup")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    @Test
//    public void createCustomer_name_16() throws Exception {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer("Tr");
//        customerDto.setDateOfBirth("18/09/2011");
//        customerDto.setGenderCustomer(1);
//        customerDto.setIdCardCustomer("12");
//        customerDto.setEmailCustomer("duc12");
//        customerDto.setAddressCustomer("danang");
//        customerDto.setPhoneCustomer1("124");
//        customerDto.setPhoneCustomer2("12");
//
//        Account account = new Account();
//        account.setUsernameAccount("duc13333");
//        account.setEncryptPassword("123456555");
//        customerDto.setAccount(account);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/customer/signup")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void createCustomer_name_17() throws Exception {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setNameCustomer("Trinh Minh Duc222222222222");
//        customerDto.setDateOfBirth("18/09/2011");
//        customerDto.setGenderCustomer(1);
//        customerDto.setIdCardCustomer("123456789222222222222222");
//        customerDto.setEmailCustomer("duc123444@gmail2222222222");
//        customerDto.setAddressCustomer("danang");
//        customerDto.setPhoneCustomer1("1234567892222222222");
//        customerDto.setPhoneCustomer2("12345678922222222222");
//
//        Account account = new Account();
//        account.setUsernameAccount("duc13333");
//        account.setEncryptPassword("123456555");
//        customerDto.setAccount(account);
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/customer/signup")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
    @Test
    public void createCustomer_name_18() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setNameCustomer("Trinh Minh Duc3");
        customerDto.setDateOfBirth("18/09/2011");
        customerDto.setGenderCustomer(1);
        customerDto.setIdCardCustomer("123456789");
        customerDto.setEmailCustomer("duc666@gmail");
        customerDto.setAddressCustomer("danang");
        customerDto.setPhoneCustomer1("123456789");
        customerDto.setPhoneCustomer2("123456789");

        Account account = new Account();
        account.setUsernameAccount("duc666");
        account.setEncryptPassword("123456555");
        customerDto.setAccount(account);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/signup")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
