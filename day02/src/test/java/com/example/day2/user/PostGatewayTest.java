package com.example.day2.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostGatewayTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void getPostById() {
        PostResponse postResponse = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", PostResponse.class);
        assertEquals(1, postResponse.getId());
        assertEquals(1, postResponse.getUserId());
    }
}