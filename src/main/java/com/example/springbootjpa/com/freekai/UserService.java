package com.example.springbootjpa.com.freekai;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public void save(){
        Address address = addressRepository.findByAddr("AAA");
//                findById("1").orElse(null);
        User u = userRepository.findById("1").orElse(null);
        User u1 = new User();
        BeanUtils.copyProperties(u,u1,new String[]{"id"});
        u1.setId("2");
        u1.setAddress(address);
        address.setUser(u1);
        userRepository.save(u1);
    }

    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }


    public Address findAddressById(String id) {
        return addressRepository.findById(id).orElse(null);
    }
}
