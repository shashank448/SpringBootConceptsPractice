package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAccessor {
    @Autowired // autowiring
    private Logger logger;
    public void talkToDB(){
        System.out.println("Talking to DB ...");
        logger.log();
    }
}
