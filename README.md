# spring bean sinlegon, prototype sample project

### applicationContext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="child" class="com.alklid.inflearn.Child"/>

    <bean id="parent" class="com.alklid.inflearn.Parent">
        <constructor-arg ref="child"/>
    </bean>
</beans>
```

### MainClass
```java
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
```

#### parent : singleton,  child : singleton
```
parent equals
parent child equals
child alone equals
```

#### parent : prototype, child : singleton
```
parent not equals
parent child equals
child alone equals
```

#### parent : singleton, child : prototype
```
parent equals
parent child equals
child alone not equals
```
	
#### parent : prototype, child : prototype
```
parent not equals
parent child not equals
child alone not equals
```
