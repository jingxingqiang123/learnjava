package com.demo.quartz.schedule.quartz.config;

import com.demo.quartz.schedule.quartz.schedule.CronScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动方式一
 */
@Component
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    public CronScheduler scheduleJobs;

    @Override
    public void run(String... args) throws Exception {
        scheduleJobs.scheduleJobs();
        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
    }
}