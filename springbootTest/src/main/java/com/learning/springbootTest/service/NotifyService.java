package com.learning.springbootTest.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotifyService {

    public void sendMessageToUer(){
        System.out.println(new Date() + "通知方法被定时任务调用，开始发送通知");
    }
}
