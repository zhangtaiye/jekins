package com.zzj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzj.handle.MyCglibProxy;
import com.zzj.handle.MyInvocationHandler;
import com.zzj.handle.ProxyFactory;
import com.zzj.service.UserService;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests
{
    @Autowired
    private UserService userService;

    @Test
    public void dynamicTest()
    {
        // 创建MyInvocationHandler 来获取代理类，从而让代理类运行login方法
        UserService proxy = (UserService) new MyInvocationHandler(userService).getProxy();
        proxy.login("admin", "123");

    }

    @Test
    public void cglibTest()
    {
        /*这样搞不方便，可以搞一个工厂
        
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(com.zyc.proxydesignpattern.dynamicproxy.cglib.UserService.class);
        enhancer.setCallback(new MyCglibProxy());
        com.zyc.proxydesignpattern.dynamicproxy.cglib.UserService userService = (com.zyc.proxydesignpattern.dynamicproxy.cglib.UserService)enhancer.create();
        userService.login("admin","4554");*/
        // 如果要是不用代理工厂的话，
        // 按照上边写就行，但是这样写更简洁一点。也更有拓展性
        // 通过代理工厂获取 代理，然后用代理去运行login
        ProxyFactory.getUserServiceProxy(new MyCglibProxy()).login("123", "3443");
    }
}
