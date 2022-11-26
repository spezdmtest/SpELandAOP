package com.proselyte.spel.aop.service;

import org.springframework.stereotype.Service;

@Service
public class PredefinedService {
    public String getString() {
        System.out.println("called PredefinedService.getString");
        return "someString";
    }

    public String getError() {
        System.out.println("called PredefinedService.getError");
        if(1==1) {
            throw new RuntimeException("Test RuntimeException ");
        }
        return "";
    }
}
