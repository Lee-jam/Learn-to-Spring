package com.study.springBatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final HelloWorldTasklet helloWorldTasklet;

    @Bean
    public Step helloWorldStep(){
        return stepBuilderFactory.get("helloWorldStep")
                .tasklet(helloWorldTasklet)
                .build();
    }

    public Job helloWorldJob(Step helloWorldStep){
        return jobBuilderFactory.get("helloWorldJob")
                .flow(helloWorldStep)
                .end()
                .build();
    }

}
