package com.proselyte.spel.example11;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class ExampleRun {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        List<User> users = new ArrayList<>();
        users.add(new User("Tom", 20));
        users.add(new User("Bill", 30));
        users.add(new User("John", 40));
        users.add(new User("Anna", 50));

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("users", users);

        {
            // фильтр
            Object value = parser.parseExpression("#users.?[age>25]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }

        {
            // фильтр и получение первого в списке
            Object value = parser.parseExpression("#users.^[age>25]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }

        {
            // фильтр и получение последнего  в списке
            Object value = parser.parseExpression("#users.$[age>25]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }

        {
            // преобразование элементов списка
            Object value = parser.parseExpression("#users.![age]").getValue(evaluationContext);
            System.out.println(value.getClass() + " - " + value);
        }



    }

    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
