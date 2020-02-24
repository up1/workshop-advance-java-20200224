package com.example.day2.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(Integer.parseInt(id));
        userResponse.setName("Demo name");
        return userResponse;
    }

}
