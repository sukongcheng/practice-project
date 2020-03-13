package com.learning.springbootTest.config;


import com.learning.springbootTest.task.QuartzTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzTaskConfig {

    @Bean
    public JobDetail simpleJobDetail(){
        return JobBuilder
                .newJob(QuartzTask.class)
                .withIdentity("quartzTaskJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger simpleJobTrigger(){
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        return TriggerBuilder
                .newTrigger()
                .forJob(simpleJobDetail())
                .withIdentity("quartzTaskJobTrigger")
                .withSchedule(simpleScheduleBuilder)
                .build();
    }
}
