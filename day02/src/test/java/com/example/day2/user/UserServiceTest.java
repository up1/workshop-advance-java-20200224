package com.example.day2.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUserById() {
        UserService userService = new UserService();
        UserResponse result = userService.getUserById(1);
        assertEquals(1, result.getId());
        assertEquals("Demo name", result.getName());
    }
}