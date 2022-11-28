package com.proselyte.spel.aop.service;

import com.proselyte.spel.aop.aspect.MeasureMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredefinedService {

    private PredefinedService selfLink;

    public PredefinedService() {
        System.out.println("construction");
    }

    @Autowired
    public void setSelfLink(PredefinedService selfLink) {
        System.out.println("Set self link");
        this.selfLink = selfLink;
    }

    @MeasureMethod
    public String getString() {
        System.out.println("called PredefinedService.getString");
        return "someString";
    }

    public String getError() {
        System.out.println("called PredefinedService.getError");
        getString();
        if (1 == 1) {
            throw new RuntimeException("Test RuntimeException ");
        }
        return "";
    }

    public String getStringThroughSelfLink() {
        System.out.println("called PredefineService.getStringThroughSelfLink");
        return selfLink.getString();
    }
}
