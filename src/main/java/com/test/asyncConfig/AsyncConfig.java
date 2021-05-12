package com.test.asyncConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("AsyncThreadPoolExecutor")
    public ThreadPoolExecutor getThreadPoolExecutor(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10,
                1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());
        return threadPool;
    }

}
