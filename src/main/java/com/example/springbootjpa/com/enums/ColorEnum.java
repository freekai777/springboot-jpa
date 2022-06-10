package com.example.springbootjpa.com.enums;

public enum ColorEnum implements ConverterBaseEnum{
    YELLOW(1,"黄"),
    RED(2,"红"),
    PURPLE(2,"紫");



    private Integer code;
    private String value;

    ColorEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String toViewValue() {
        return String.valueOf(code);
    }

    public static void main(String[] args) {
        System.out.println(YELLOW.toViewValue());
    }
}
