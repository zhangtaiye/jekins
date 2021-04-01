package com.zzj.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.zzj.domain.Person;

public class ThreadDemo
{

    public static void main(String[] args) throws InterruptedException
    {
        Person p = new Person("fff", 2);
        Executor e = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++) {
            e.execute(new Runnable()
            {
    
                @Override
                public void run()
                {
                    p.setName("uuu");
                    System.out.println("ddddd"+"---"+Thread.currentThread().getName());
                }
            });
        }
        Thread.sleep(2000);
       System.out.println(p.getName());
    }
    // ���߳�ͬ��
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
   /* public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 1; i < 2; i++)
        {
            int y=i;
            Future<String> future = executorService.submit(() -> {
                Thread.sleep(2000);
                return y+"";
            });

            try
            {
                String result = future.get(1, TimeUnit.SECONDS);
                System.out.println("result:" + result);
            }
            catch (Exception e)
            {
                System.out.println("超时了!");
            }
        }
        executorService.shutdown();

    }*/

}
