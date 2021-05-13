package com.test.service.impl;

import com.test.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncServerImpl implements AsyncService {
    private static int DOCOUNT = 50;

    @Override
    public String AsyncServer() {
        long start = System.currentTimeMillis();
        for(int i=0; i<DOCOUNT; i++){
            this.AsyncExe();
        }
        long end = System.currentTimeMillis();
        System.out.println("!!!!!time: "+(start-end));
        return String.valueOf(start-end);
    }

    @Async(value = "AsyncThreadPoolExecutor")
    public void AsyncExe(){
        try {
            Thread.sleep(1000);
            System.out.println("study @Async");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String Server(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10,
                1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());
        long start = System.currentTimeMillis();
        for(int i=0; i<DOCOUNT; i++){
            threadPool.execute(() -> this.Exe());
        }
        threadPool.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("!!!!!time2: "+(start-end));
        return String.valueOf(start-end);
    }

    public void Exe(){
        try {
            Thread.sleep(1000);
            System.out.println("study Exe");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
