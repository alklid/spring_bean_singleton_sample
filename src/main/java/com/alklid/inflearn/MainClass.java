package com.alklid.inflearn;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        Parent parent1 = ctx.getBean("parent", Parent.class);
        Parent parent2 = ctx.getBean("parent", Parent.class);

        if (parent1.equals(parent2)) {
            System.out.println("parent equals");
        } else {
            System.out.println("parent not equals");
        }

        if (parent1.getChild().equals(parent2.getChild())) {
            System.out.println("parent child equals");
        } else {
            System.out.println("parent child not equals");
        }

        Child child1 = ctx.getBean("child", Child.class);
        Child child2 = ctx.getBean("child", Child.class);

        if (child1.equals(child2)) {
            System.out.println("child alone equals");
        } else {
            System.out.println("child alone not equals");
        }

        ctx.close();
    }
}
