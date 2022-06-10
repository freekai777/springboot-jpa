package com.example.springbootjpa.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ThemeChangeInterceptor t = new ThemeChangeInterceptor();
        registry.addInterceptor(t);
    }


    /**
     * 配置转化string值 为对应的枚举值，当通过接口传入 color=1 会映射成 code为1的枚举：eg: ConverterBaseEnum.YELLOW
     */
    @Autowired
    EnumsConvertorFactory enumsConvertorFactory;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(enumsConvertorFactory);
    }
}
