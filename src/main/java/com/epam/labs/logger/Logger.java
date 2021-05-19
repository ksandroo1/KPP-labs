package com.epam.labs.logger;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class Logger {
    public void doLog(String message){
        log.info(message);
    }
}
