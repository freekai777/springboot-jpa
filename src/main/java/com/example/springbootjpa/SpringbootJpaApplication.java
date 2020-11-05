package com.example.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.theme.FixedThemeResolver;
import org.springframework.web.servlet.theme.SessionThemeResolver;

@SpringBootApplication
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

    @Bean
    public ResourceBundleThemeSource themeSource(){
        ResourceBundleThemeSource resourceBundleThemeSource = new ResourceBundleThemeSource();
        resourceBundleThemeSource.setBasenamePrefix("theme-");
        resourceBundleThemeSource.setDefaultEncoding("utf-8");
        return resourceBundleThemeSource;
    }
    @Bean
    public SessionThemeResolver themeResolver(){
        SessionThemeResolver fixedThemeResolver = new SessionThemeResolver();
        fixedThemeResolver.setDefaultThemeName("red");
        return fixedThemeResolver;
    }
}
