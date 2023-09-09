package com.example.accountTest;

import com.example.accountTest.Dto.UserDTO;
import com.example.accountTest.Entity.User;
import com.example.accountTest.Repo.UserRepo;
import com.example.accountTest.Service.impl.UserIMPL;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = {AccountTestApplication.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class JPAtesting {


    @Mock
    MockHttpServletRequest request;
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup()  {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.wac)
                .build();
    }

    @Test
    public void saveEmployeeTest() throws Exception {
        User user = new User(
                1,
                "test",
                "testing",
                "test address",
                "test@gmail.com",
                "test"
        );
        request = new MockHttpServletRequest();
        request.setRequestURI("http://localhost:8080/register-ms");
        String uri = "/register/save";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user))).andExpect(status().isOk());
    }
}
