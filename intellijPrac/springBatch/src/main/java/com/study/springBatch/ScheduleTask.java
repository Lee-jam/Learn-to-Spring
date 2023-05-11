package com.study.springBatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ScheduleTask {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private BatchConfig batchConfig;

    @Scheduled(fixedDelay = 2000)
    @Scheduled(cron="0 0 9 * * *") //아침 9시 마다 실행
    public void task(){
        System.out.println("time1:"+ LocalDateTime.now());
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(confMap);

        try{
            jobLauncher.run(batchConfig.helloWorldJob(batchConfig.helloWorldStep()),jobParameters);
        }catch(JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException
                | JobParametersInvalidException | org.springframework.batch.core.repository.JobRestartException e){
            log.error(e.getMessage());

        }
    }
}
