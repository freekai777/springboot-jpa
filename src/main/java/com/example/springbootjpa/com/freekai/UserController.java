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

    /**
     * 在实体类中增加注解 及 对应的方法  ==> 可以理解为事件驱动模型
     * 1.@DomainEvents
     * 2.@AfterDomainEventPublication 在 @DomainEvents 注解存在时生效
     *
     *
     *
     * 执行顺序...
     * 1.com.example.springbootjpa.com.freekai.UserService#save() --> 在 userRepository.save(u1) 保存前
     * 2.com.example.springbootjpa.com.freekai.User#domainEvents()
     * 3.com.example.springbootjpa.com.freekai.User#callbackMethod()
     * 4.com.example.springbootjpa.com.freekai.UserService#save()
     * 5.com.example.springbootjpa.com.freekai.UserService#save() --> 在 userRepository.save(u1) 保存后
     * @return
     */
    @GetMapping("/tt")
    public String testSave(){
        userService.save();
        System.out.println("接口返回前...");
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
