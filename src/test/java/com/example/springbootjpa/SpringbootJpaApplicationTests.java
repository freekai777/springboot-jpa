package com.example.springbootjpa;

import com.example.springbootjpa.com.freekai.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SpringbootJpaApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }


    @Test
    @Transactional
    public void testSave(){
        userService.save();
    }

}
