package com.epam.labs.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CounterService {
    private AtomicInteger counter = new AtomicInteger(0);

    public int incrementAndGetCounter(){
        return counter.incrementAndGet();
    }
}
