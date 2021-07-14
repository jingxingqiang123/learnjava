package com.demo.quartz.schedule.quartz.schedule;

import com.demo.quartz.schedule.quartz.job.SampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Scheduler ->  Trigger -> JobDetails -> Job
 */
@Configuration
public class SampleScheduler {

    @Bean
    public JobDetail sampleJobDetail() {
        // 链式编程,可以携带多个参数,在Job类中声明属性 + setter方法

        /**
         * JobBuilder 无构造函数，只能通过 JobBuilder 的静态方法 newJob(Class jobClass)生成 JobBuilder 实例。
         * withIdentity 方法可以传入两个参数 withIdentity(String name,String group) 来定义 TriggerKey，也可以不设置，
         * 像上文示例中会自动生成一个独一无二的 TriggerKey 用来区分不同的 Trigger。
         */
        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
                .usingJobData("name","World")
                .storeDurably().build();
    }

    @Bean
    public Trigger sampleJonTrigger() {
        // 每隔一秒执行一次 任务的出发规则
        // SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.repeatMinutelyForever();

        // 每隔两秒执行一次 任务的出发规则
        SimpleScheduleBuilder simpleScheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(sampleJobDetail()).withIdentity("sampleTrigger")
                .withSchedule(simpleScheduleBuilder)
                .build();
    }
}
