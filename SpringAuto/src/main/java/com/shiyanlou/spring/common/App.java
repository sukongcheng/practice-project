package com.shiyanlou.spring.common;

import com.shiyanlou.spring.config.SpringConfig;
import com.shiyanlou.spring.entity.Client;
import com.shiyanlou.spring.entity.CustomerService;
import com.shiyanlou.spring.entity.Dog;
import com.shiyanlou.spring.service.CustomerBo;
import com.shiyanlou.spring.service.ICustomerBo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("SpringCustomer.xml");
//        CustomerService customerService = (CustomerService) context.getBean("customerService");
//        System.out.println(customerService);

//        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        Dog dog = (Dog) context.getBean("dog");
//        System.out.println(dog);

//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Client client = context.getBean(Client.class);
//        client.sayHello();

        /**
         * AOP ProxyFactoryBean实现
         */
//        ApplicationContext context = new ClassPathXmlApplicationContext("SpringAOPAdvice.xml");
//        CustomerService customerService = (CustomerService) context.getBean("customerService");
//        System.out.println("******************");
//        customerService.printName();
//        System.out.println("******************");
//        customerService.printUrl();
//        System.out.println("******************");
//        customerService.throwException();

        /**
         * AOP Aspectj实现
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringAopAspect.xml");
        ICustomerBo customerBo = (ICustomerBo) context.getBean("customerBo");
        customerBo.addCustomer();
        System.out.println("----------------------------");
        customerBo.deleteCustomer();
    }
}
