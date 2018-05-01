package com.bswen.sbah.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xxx on 2018/4/23.
 */
@Configuration
public class ExecutorServiceConfig {

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(5);
        executor.setThreadNamePrefix("MyAsync-");
        executor.initialize();
        return executor;
    }

    @Bean("customFixedThreadPool")
    public ExecutorService customFixedThreadPool() {
        return Executors.newFixedThreadPool(2,new CustomizableThreadFactory("customFixedThreadPool"));
    }

}
