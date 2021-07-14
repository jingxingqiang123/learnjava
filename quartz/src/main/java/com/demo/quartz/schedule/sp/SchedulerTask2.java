package com.demo.quartz.schedule.sp;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask2 {
    
    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy:MM:dd HH:mm:ss dd");
    
    /**
     * @Description 设置没6秒执行一次
     * @Date 14:22 2019/1/24
     * @Param 
     * @return void
     **/
    @Scheduled(fixedRate = 6000)
    private void process(){
        System.out.println("now time is " + dateFormat.format(new Date()));
    }
    
}