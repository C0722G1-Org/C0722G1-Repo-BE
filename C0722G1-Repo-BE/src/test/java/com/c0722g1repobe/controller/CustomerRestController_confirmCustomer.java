package com.c0722g1repobe.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerRestController_confirmCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    /**
     * Note: Sử dụng MockMvcRequestBuilders.delete cho phương thức cập nhật 1 record(column, attributes) vì:
     *       Tính chất của phương thức confirmCustomer tương tự với phương thức dùng để xóa mềm, có tác dụng
     *          cập nhật dữ liệu của column(attributes: thuộc tính) của confirmCustomer.
     *
     *       The properties of the confirmCustomer method are similar to the method used for soft deletion,
     *          which updates the data of the column(attributes: attribute) of confirmCustomer.
     */
    public void confirmCustomer_id_25(){
        try {
            this.mockMvc.perform(
                            MockMvcRequestBuilders.delete("/api/customer/{id}", "null"))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmCustomer_id_26(){
        try {
            this.mockMvc.perform(
                            MockMvcRequestBuilders.delete("/api/customer/{id}", ""))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmCustomer_id_27(){
        try {
            this.mockMvc.perform(
                            MockMvcRequestBuilders.delete("/api/customer/{id}", 100))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmCustomer_id_28(){
        try {
            this.mockMvc.perform(
                            MockMvcRequestBuilders.delete("/api/customer/{id}", 1))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
