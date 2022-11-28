package com.proselyte.spel.aop.service;

import com.proselyte.spel.aop.aspect.MeasureMethod;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RndService {
    @MeasureMethod
    public String getString() {
        System.out.println("called RndService");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        return UUID.randomUUID().toString();
    }
}
