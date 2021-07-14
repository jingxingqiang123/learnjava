//package com.demo.quartz.schedule.quartz.config;
//
//import com.demo.quartz.schedule.quartz.schedule.CronScheduler;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * 启动方式二
// */
//@Configuration
//@EnableScheduling
//@Component
//public class SchedulerListener {
//
//    @Autowired
//    public CronScheduler cronScheduler;
//
//    @Scheduled(cron = "0 47 16 24 1 ?")
//    public void schedule() throws SchedulerException {
//        cronScheduler.scheduleJobs();
//        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
//    }
//
//}