package com.mumu.springbootvue.repository;

import com.mumu.springbootvue.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void findAll() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}