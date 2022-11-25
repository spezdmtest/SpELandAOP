package com.proselyte.spel.example10;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExampleRun {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Object value = parser.parseExpression("new com.proselyte.spel.example02.User('Jim')")
                .getValue();
        System.out.println(value);
    }
}
