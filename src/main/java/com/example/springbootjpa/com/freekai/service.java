package com.example.springbootjpa.com.freekai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class service {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;
}
