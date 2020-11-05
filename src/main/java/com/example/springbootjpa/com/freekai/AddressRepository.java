package com.example.springbootjpa.com.freekai;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,String> {

    Address findByAddr(String aaa);
}
