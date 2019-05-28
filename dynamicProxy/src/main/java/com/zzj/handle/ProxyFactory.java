package com.zzj.handle;

import com.zzj.domain.Login;

import net.sf.cglib.proxy.Enhancer;

//代理工厂
public class ProxyFactory
{
    /**
     * 防止在外边创建
     */
    private ProxyFactory()
    {
    }

    // 代理工厂方法。
    // 这几天有时间的话 在写个工厂设计模式
    public static Login getUserServiceProxy(MyCglibProxy myCglibProxy)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(com.zzj.domain.Login.class);
        enhancer.setCallback(new MyCglibProxy());
        // 这里就不详细写了，cglib功能挺多的
        // setCallbacks可是设置多个代理，然后根据 setCallbackFilter 的 accept 方法 看哪个方法走哪个代理。
        // enhancer.setCallbacks(new Callback[]{new MyCglibProxy()});
        // enhancer.setCallbackFilter((Method method)-> {
        //
        // return 0;
        // });
        return (com.zzj.domain.Login) enhancer.create();
    }
}