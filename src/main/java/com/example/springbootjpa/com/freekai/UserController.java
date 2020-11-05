package com.example.springbootjpa.com.freekai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/tt")
    public String testSave(){
        userService.save();
        return "12";
    }
}
