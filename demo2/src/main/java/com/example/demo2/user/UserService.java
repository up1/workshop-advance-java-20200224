package com.example.demo2.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDomain getData(int id) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(id);
        userDomain.setName("Demo name");
        return  userDomain;
    }

}
