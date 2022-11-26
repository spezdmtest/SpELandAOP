package com.proselyte.spel;

import com.proselyte.spel.aop.service.PredefinedService;
import com.proselyte.spel.aop.service.RndService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpELApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpELApplication.class, args);

        System.out.println("************************************");
        RndService rndService = context.getBean(RndService.class);
        System.out.println(rndService.getString());
        System.out.println("************************************");

        System.out.println("************************************");
        PredefinedService predefinedService = context.getBean(PredefinedService.class);
        System.out.println(predefinedService.getString());
        System.out.println("************************************");

        System.out.println("************************************");
        try {
        String error = predefinedService.getError();
        } catch (Exception ignored) {}
        System.out.println("************************************");
    }
}
