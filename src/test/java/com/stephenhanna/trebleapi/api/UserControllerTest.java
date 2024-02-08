package com.stephenhanna.trebleapi.api;

import com.stephenhanna.trebleapi.entity.User;
import com.stephenhanna.trebleapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUsers_shouldReturn200_whenNoException() throws Exception {
        User user1 = new User(1,"test_name", "test", "test", "test", LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), "test");

        List<User> expectedResponseBody = List.of(user1);

        given(userService.getUsers()).willReturn(expectedResponseBody);
        mockMvc.perform(get("/api/v1/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value(user1.getFirstName()));
    }
}
