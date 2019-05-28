package com.zzj.handle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler
{

    // 目标方法
    private Object target;

    public MyInvocationHandler(Object target)
    {
        this.target = target;
    }

    public Object getProxy()
    {
        // 获取该类的代理
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 通过反射让方法运行。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("---前置---");
        Object result = method.invoke(target, args);
        System.out.println("---后置---");
        return result;
    }
}