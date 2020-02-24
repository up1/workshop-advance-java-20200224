package com.example.day2.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void getUserById1() {
        User newUser = new User();
        newUser.setName("Demo");
        this.entityManager.persist(newUser);

        Optional<User> user = this.repository.findById(1);
        assertEquals(1, user.get().getId());
        assertEquals("Demo", user.get().getName());
    }

}