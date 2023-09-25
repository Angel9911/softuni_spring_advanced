package com.example.springsecurity.web;

import com.example.springsecurity.model.view.StatView;
import com.example.springsecurity.service.StatService;
import org.springframework.stereotype.Controller;

@Controller
public class StatController {
    private final StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    public String statistic(){
        StatView stats = statService.getStats();

        return String.format("authenication request: %d, anonymous: %d, total is %d", stats.getAuthRequests(), stats.getAnonymousRequests(), stats.getTotalRequests());
    }
}
