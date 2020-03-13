package com.learning.springbootTest.task;

import com.learning.springbootTest.service.NotifyService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class QuartzTask extends QuartzJobBean {

    @Autowired
    private NotifyService notifyService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + "Quartz开始执行定时任务");
        notifyService.sendMessageToUer();
    }
}
