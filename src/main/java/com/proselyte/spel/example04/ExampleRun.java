package com.proselyte.spel.example04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleRun {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ValueHolder bean = context.getBean(ValueHolder.class);
        System.out.println(bean);
    }
}
