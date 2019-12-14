package com.example.demo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MockTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }
    @Test
    public void valid_username_valid_pass() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/testmock")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"usernameOrEmail\" : \"test\", \"password\" : \"test\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value("success"))
                .andDo(print());
    }
    @Test
    public void invalid_username_valid_pass() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/testmock")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"usernameOrEmail\" : \"t\", \"password\" : \"test\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value("false"))
                .andExpect(jsonPath("$.message").value("failed"))
                .andDo(print());
    }
    @Test
    public void valid_username_invalid_pass() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/testmock")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"usernameOrEmail\" : \"test\", \"password\" : \"t\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value("false"))
                .andExpect(jsonPath("$.message").value("failed"))
                .andDo(print());
    }
    @Test
    public void invalid_username_invalid_pass() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/testmock")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"usernameOrEmail\" : \"t\", \"password\" : \"t\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value("false"))
                .andExpect(jsonPath("$.message").value("failed"))
                .andDo(print());
    }
    }
