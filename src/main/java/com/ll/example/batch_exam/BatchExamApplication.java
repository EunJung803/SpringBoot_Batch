package com.ll.example.batch_exam;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchExamApplication.class, args);
    }

}
