package com.proselyte.spel.example09;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.UUID;

public class ExampleRun {
    public static void main(String[] args) throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.registerFunction("rndUuid",
                ServiceRnd.class.getDeclaredMethod("uuid", String.class));

        {
            String value = parser.parseExpression("#rndUuid('test')")
                    .getValue(evaluationContext, String.class);
            System.out.println(value);
        }

        {
            String value = parser.parseExpression("#rndUuid(1 > 0 ? 'true' : 'false')")
                    .getValue(evaluationContext, String.class);
            System.out.println(value);
        }

        {
            evaluationContext.setVariable("val", null);
            String value = parser.parseExpression("#val?:'ItIsNull'")
                    .getValue(evaluationContext, String.class);
            System.out.println(value);
        }
    }

    public static class ServiceRnd {
        static String uuid(String prefix) {
            return prefix + " - " + UUID.randomUUID().toString();
        }
    }
}
