package com.example.springsecurity.config;

import com.example.springsecurity.web.interceptors.StatInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfiguration implements WebMvcConfigurer {
    private final StatInterceptor statInterceptor;

    public WebConfiguration(StatInterceptor statInterceptor) {
        this.statInterceptor = statInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statInterceptor);
    }
}
