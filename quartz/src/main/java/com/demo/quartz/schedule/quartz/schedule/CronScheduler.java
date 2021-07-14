package com.demo.quartz.schedule.quartz.schedule;

import com.demo.quartz.schedule.quartz.job.ScheduledJob;
import com.demo.quartz.schedule.quartz.job.ScheduledJob2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class)
                .withIdentity("job1", "group1").build();
        // 6的倍数秒执行 也就是 6 12 18 24 30 36 42 ....
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .usingJobData("name", "王者1")
                .withSchedule(cronScheduleBuilder)
                .build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class)
                .withIdentity("job2", "group2")
                .build();
        // 12秒的倍数执行  12  24 36  48  60
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/12 * * * * ?");

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group2")
                .usingJobData("name", "王者2")
                .withSchedule(cronScheduleBuilder)
                .build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    /**
     * 同时启动两个定时任务
     * @throws SchedulerException
     */
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }

}
