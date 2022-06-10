package com.example.springbootjpa.com;

import com.example.springbootjpa.com.config.ExamplePOJO;
import com.example.springbootjpa.com.enums.ColorEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    /**
     *
     * com.example.springbootjpa.com.config.WebConfig#addFormatters(org.springframework.format.FormatterRegistry)
     *
     * case1>> 当未在WebConfig中配置addFormatters时，通过接口请求
     *   http://localhost:9877/getColor?color=1
     *   会报错如下:
     *     "timestamp": "2022-06-10T07:14:31.812+0000",
     *     "status": 400,
     *     "error": "Bad Request",
     *     "message": "Failed to convert value of type 'java.lang.String' to required type 'com.example.springbootjpa.com.enums.ColorEnum'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [com.example.springbootjpa.com.enums.ColorEnum] for value '1'; nested exception is java.lang.IllegalArgumentException: No enum constant com.example.springbootjpa.com.enums.ColorEnum.1",
     *     "path": "/getColor"
     *
     * case2>> 当配置后
     *  http://localhost:9877/getColor?color=1
     *
     *  请求可以正常进入，接口中的color会自动映射出来
     *  返回结果： “YELLOW”
     *
     * @param color
     * @return
     */
    @ResponseBody
    @GetMapping("/getColor")
    public ColorEnum getColor(ColorEnum color){
        return color;
    }

    /**
     * 验证自定义 org.springframework.core.convert.converter.Converter 实现类，将string参数转化为List<ExamplePOJO>
     *
     *    见：StringToExamplePOJOConverter
     * @param list
     */
    @ResponseBody
    @GetMapping("/testConvert")
    public void testConvertByImplements(@RequestParam("list") List<ExamplePOJO> list){
        for (ExamplePOJO examplePOJO : list) {
            System.out.println(examplePOJO);
        }
    }
}
