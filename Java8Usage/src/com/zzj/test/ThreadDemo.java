package com.zzj.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zzj.domain.TestRunnable;

public class ThreadDemo
{

    // 多线程异步
    /*public static void main(String[] args)
    {
        Executor e = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++) {
            e.execute(new Runnable()
            {
    
                @Override
                public void run()
                {
                    System.out.println("ddddd"+"---"+Thread.currentThread().getName());
                }
            });
        }
       
    }*/
    // 多线程同步
    /*public static void main(String[] args)
    {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        CountDownLatch end = new CountDownLatch(10);
    
        for (int i = 0; i < 10; i++)
        {
            Thread t = new Thread()
            {
                @Override
                public void run()
                {
                    try
                    {
    
                        System.out.println("ddddd" + "---" + Thread.currentThread().getName());
                    }
                    catch (Exception e)
                    {
                    }
                    finally
                    {
                        end.countDown();
                    }
                }
            };
            executors.submit(t);
        }
        try
        {
    
            end.await();
        }
        catch (Exception e)
        {
        }
        executors.shutdown();
        System.out.println("bbbbbb");
    }*/
    public static void main(String[] args)
    {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        CountDownLatch end = new CountDownLatch(10);

        for (int i = 0; i < 10; i++)
        {
            executors.execute(new TestRunnable(end));
        }
        try
        {
            end.await();
        }
        catch (Exception e)
        {
        }
        finally
        {
            executors.shutdown();
        }

        System.out.println("bbbbbb");
    }

}
