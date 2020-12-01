package io.syria.semiAutoAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SemiAnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanComponentScan.xml");
        User user = (User)ctx.getBean("user");
        System.out.println(user);

        UserServiceIml userService = (UserServiceIml) ctx.getBean("userService");
        System.out.println(userService);

        UserController userController = (UserController)ctx.getBean("userController");
        System.out.println(userController);
    }
}
