package com.proselyte.spel.example04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueHolder {
    private String value;

    public ValueHolder(@Value("#{systemProperties['java.home']}") String val) {
        System.out.println("created with value " + val);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ValueHolder{" +
                "value='" + value + '\'' +
                '}';
    }
}
