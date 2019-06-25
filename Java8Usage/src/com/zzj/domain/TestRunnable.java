package com.zzj.domain;

import java.util.concurrent.CountDownLatch;

public class TestRunnable implements Runnable{
    private CountDownLatch countDownLatch;

    public TestRunnable( CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run()
    {
        try {
            System.out.println("ddddd" + "---" + Thread.currentThread().getName());
        }catch(Exception e) {
           
        }finally {
            countDownLatch.countDown();
        }
    }
    
}