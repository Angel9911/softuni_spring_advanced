package com.example.springsecurity.web.interceptors;

import com.example.springsecurity.service.StatService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class StatInterceptor implements HandlerInterceptor {
    private final StatService statService;

    @Autowired
    public StatInterceptor(StatService statService) {
        this.statService = statService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method is Calling");
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
