package com.example.day2.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostGatewayTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    void getPostById() {
        Optional<PostResponse> postResponse = postGateway.getPostById(1);
        assertEquals(1, postResponse.get().getId());
        assertEquals(1, postResponse.get().getUserId());
    }
}