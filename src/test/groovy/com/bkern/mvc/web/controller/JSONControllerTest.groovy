package com.bkern.mvc.web.controller

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/springConfig/main.xml")
class JSONControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetData() throws Exception{
       this.mockMvc.perform(get("/getData/{id}","barry"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath('$.name').value("wayne"))
        .andExpect(jsonPath('$.age').value(99))
        .andExpect(jsonPath('$.sampleData').value('this is some sample data'))
        .andExpect(jsonPath('$.count').value(34))
//        .andExpect(jsonPath('$.role').value(UserData.USER_ROLES.USER.value()))
    }

    @Test
    void testSaveUser() throws Exception {
        this.mockMvc.perform(
                            post("/user/")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("{ \"age\": \"23\", \"name\": \"Bob\" }".getBytes()))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
    }

    @Test
    void testSaveUserNotFound() throws Exception {
        this.mockMvc.perform(
                post("/user/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"age\": \"43\", \"name\": \"Tim\" }".getBytes()))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
    }

    @Test
    void testSaveUserSecurityError() throws Exception {
        this.mockMvc.perform(
                post("/user/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"age\": \"37\", \"name\": \"Bob\" }".getBytes()))
                .andExpect(status().isForbidden())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
    }
}
