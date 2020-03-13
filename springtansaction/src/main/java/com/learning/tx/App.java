package com.learning.tx;

import com.learning.tx.service.AccountService;
import com.learning.tx.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transfer("Tom", "Marry", 1000);
    }
}
