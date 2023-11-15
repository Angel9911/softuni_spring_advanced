package com.example.springevents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class ApplicationListenerTest {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationListenerTest.class);

    @EventListener(ServletRequestHandledEvent.class)
    public void onApplicationEvent(ServletRequestHandledEvent event){
        logger.info(" i have received an event {}",event);
    }
}
