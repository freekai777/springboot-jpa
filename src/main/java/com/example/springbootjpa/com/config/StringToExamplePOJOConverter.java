package com.example.springbootjpa.com.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringToExamplePOJOConverter implements Converter<String, List<ExamplePOJO>> {
    @Override
    public List<ExamplePOJO> convert(String s) {
        String[] split = s.split("@@");
        List<ExamplePOJO> pojoList = new ArrayList<>();
        for (String s1 : split) {
            ExamplePOJO pojo = new ExamplePOJO();
            pojo.setName(s1);
            pojoList.add(pojo);
        }
        return pojoList;
    }
}
