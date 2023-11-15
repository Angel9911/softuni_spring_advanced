package com.example.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventsApplication {
    // https://crontab.guru/#*_*_*_*_* this site could be used to generate a cron expression which you can set it in appication.properties
    public static void main(String[] args) {
        SpringApplication.run(EventsApplication.class, args);
    }

}
