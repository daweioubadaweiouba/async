package com.test.studyAsync;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class testAsync{

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10,
                                                               1, TimeUnit.SECONDS,
                                                               new LinkedBlockingQueue<>(100),
                                                               new ThreadPoolExecutor.AbortPolicy());

        long start = System.currentTimeMillis();
        for(int i =0; i<100; i++){
            threadPool.execute(() -> {
                System.out.println("study @Async");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        long end = System.currentTimeMillis();

        System.out.println("time :" + (start-end));
    }

}
