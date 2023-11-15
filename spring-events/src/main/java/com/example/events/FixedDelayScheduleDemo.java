package com.example.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FixedDelayScheduleDemo {
    private static final Logger logger = LoggerFactory.getLogger(FixedDelayScheduleDemo.class);


    @Scheduled(fixedRate = 5000)
    public void showTimeWithFixedDelay(){
        logger.info("hello from fixed rate at {}", LocalDateTime.now());
    }
}
