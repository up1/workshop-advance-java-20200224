package com.example.day2.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse getUserById(int id) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(id);
        userResponse.setName("Demo name");
        return userResponse;
    }

}
