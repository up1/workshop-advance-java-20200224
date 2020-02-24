package com.example.day2.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void getUserById() {
        User stubUser = new User();
        stubUser.setId(1);
        stubUser.setName("Demo name");
        given(userRepository.findById(1))
                .willReturn(Optional.of(stubUser));

        UserService userService = new UserService(userRepository);
        UserResponse result = userService.getUserById(1);
        assertEquals(1, result.getId());
        assertEquals("Demo name", result.getName());
    }

}