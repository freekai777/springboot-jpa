package com.example.springbootjpa.com.config;

public class ExamplePOJO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExamplePOJO{" +
                "name='" + name + '\'' +
                '}';
    }
}
