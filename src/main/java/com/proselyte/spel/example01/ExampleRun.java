package com.proselyte.spel.example01;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExampleRun {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Welcome'.concat(' To ').concat('Paradise')");
        System.out.println(expression.getValue(String.class));
    }
}
