package com.ll.example.batch_exam.job.helloWorld;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloWorldJob() {    // job 생성
        return jobBuilderFactory.get("helloWorldJob")   // job 빌더를 가져옴
                .incrementer(new RunIdIncrementer()) // 강제로 매번 다른 ID를 실행시에 파라미터로 부여
                .start(helloWorldStep1())
                .build();
    }

    @JobScope
    @Bean
    public Step helloWorldStep1() {     //step 생성
        return stepBuilderFactory.get("helloWorldStep1")
                .tasklet(helloWorldTasklet())
                .build();
    }

    @StepScope
    @Bean
    public Tasklet helloWorldTasklet() {    // Tasklet 생성
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("스프링 배치 Hello World !");
                return RepeatStatus.FINISHED;   // 성공 or 실패의 여부를 return
            }
        };
    }
}