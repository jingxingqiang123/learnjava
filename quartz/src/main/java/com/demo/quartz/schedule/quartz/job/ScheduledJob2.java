package com.demo.quartz.schedule.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledJob2 implements Job {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println(
                "CRON ----> schedule job2 is running ... + " + name + "  ---->  " + dateFormat.format(new Date()));
    }
}
