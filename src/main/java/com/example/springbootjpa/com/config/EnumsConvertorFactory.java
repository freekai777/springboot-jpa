package com.example.springbootjpa.com.config;

import com.example.springbootjpa.com.enums.ConverterBaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EnumsConvertorFactory implements ConverterFactory<String, ConverterBaseEnum> {
    @Override
    public <T extends ConverterBaseEnum> Converter<String, T> getConverter(Class<T> aClass) {
        return s -> {
            for (T enumConstant : aClass.getEnumConstants()) {
                if(Objects.equals(s, enumConstant.toViewValue())){
                    return enumConstant;
                }
            }
            return null;
        };
    }
}
