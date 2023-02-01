package com.c0722g1repobe.controller;

import com.c0722g1repobe.dto.account.request.SignInForm;
import com.c0722g1repobe.repository.account.IAccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_login {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void login_13() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername(null);
        signInForm.setPassword("123123");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin")
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_13_1() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername("admin");
        signInForm.setPassword(null);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin")
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_13_2() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername(null);
        signInForm.setPassword(null);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin")
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_14() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername("");
        signInForm.setPassword("123123");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin")
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_14_1() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername("admin");
        signInForm.setPassword("");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin")
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_14_2() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername("");
        signInForm.setPassword("");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin")
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_15and16and17() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername("admin1"); // tài khoản sai
        signInForm.setPassword("123123"); // mật khẩu đúng

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin")
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void login_18() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername("admin");
        signInForm.setPassword("123123");

        this.mockMvc
                .perform(
                    MockMvcRequestBuilders
                            .post("/api/signin")
                            .content(this.objectMapper.writeValueAsString(signInForm))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void login_99() throws Exception {
        SignInForm signInForm = new SignInForm();

        signInForm.setUsername("admin");
        signInForm.setPassword("123123");

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/api/signin1") // sai đường dẫn
                                .content(this.objectMapper.writeValueAsString(signInForm))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
