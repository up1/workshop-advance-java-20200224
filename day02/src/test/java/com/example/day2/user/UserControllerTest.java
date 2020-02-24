package com.example.day2.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Test
    void getUserById(@Autowired TestRestTemplate restTemplate) {
        UserResponse result = restTemplate.getForObject("/user/1", UserResponse.class);
        assertEquals(1, result.getId());
        assertEquals("Demo name", result.getName());
    }
}