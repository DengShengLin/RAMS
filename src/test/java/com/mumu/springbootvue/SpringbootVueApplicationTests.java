package com.mumu.springbootvue;

import com.mumu.springbootvue.entity.User;
import com.mumu.springbootvue.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootVueApplicationTests {


    @Resource
    private UserRepository userRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void save(){
        User user = new User();
        user.setUserName("deng");
        user.setUserTel("679293");
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }

}
