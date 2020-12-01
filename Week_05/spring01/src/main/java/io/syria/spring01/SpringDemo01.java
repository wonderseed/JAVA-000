package io.syria.spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo01 {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1234 =(Student)context.getBean("student123");
        System.out.println(student1234.toString());

        System.out.println("------------------");

        School1 school1 = (School1)context.getBean("school1");
        school1.saySomething();
    }
}
