package com.example.day2.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Test
    void getUserById(@Autowired TestRestTemplate restTemplate) {
        UserResponse stubUserResponse = new UserResponse();
        stubUserResponse.setId(1);
        stubUserResponse.setName("Demo name");
        given(userService.getUserById(1))
                .willReturn(stubUserResponse);

        UserResponse result = restTemplate.getForObject("/user/1", UserResponse.class);
        assertEquals(1, result.getId());
        assertEquals("Demo name", result.getName());
    }
}