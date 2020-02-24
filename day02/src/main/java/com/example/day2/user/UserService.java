package com.example.day2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(id);
            userResponse.setName(user.get().getName());
            return  userResponse;
        }
        throw new RuntimeException(String.format("User %d not found", id));
    }

}
