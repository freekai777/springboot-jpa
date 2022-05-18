package com.example.springbootjpa.com.freekai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/tt")
    public String testSave(){
        userService.save();
        return "12";
    }

    @GetMapping("/users/{id}")
    public String testQueryUser(@PathVariable String id){
        User u = userService.findUserById(id);
        return Optional.ofNullable(u).map(User::getName).orElse("xxx");
    }
    @GetMapping("/address/{id}")
    public String testQueryAddress(@PathVariable String id){
        Address add = userService.findAddressById(id);
        return Optional.ofNullable(add).map(item->item.getAddr()).orElse("null address..00");
    }
}
