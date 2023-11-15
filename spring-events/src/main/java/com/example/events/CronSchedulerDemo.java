package com.example.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CronSchedulerDemo {
    private static final Logger logger = LoggerFactory.getLogger(CronSchedulerDemo.class);

    @Scheduled(cron = "${schedulers.cron}")
    public void showTimeWithCron(){
        logger.info("hello from cron scheduler at {}", LocalDate.now());
    }
}
