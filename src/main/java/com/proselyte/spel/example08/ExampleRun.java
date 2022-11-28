package com.proselyte.spel.example08;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class ExampleRun {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        SimpleContext simpleContext = new SimpleContext();
        simpleContext.values.add("aaa");
        simpleContext.values.add("bbb");
        simpleContext.values.add("ccc");
        simpleContext.values.add("ddd");
        simpleContext.values.add("eee");
        simpleContext.values.add("fff");

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("newValues", simpleContext.values);

        Object result = parser.parseExpression("#newValues.?[#this>'bbb']")
                .getValue(evaluationContext);
        System.out.println(result);
    }

    public static class SimpleContext {
        public List<String> values = new ArrayList<>();
    }
}
