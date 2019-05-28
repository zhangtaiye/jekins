package com.zzj.domain;

//被代理类
public class Login
{
    // 在用cglib的时候， UserService可以没有接口。
    // 但是 login 方法不能用final修饰,不能用private修饰 ，因为cglib的代理原理是找该类的子类去继承该方法去实现，
    // 如果用private 或者 final 修饰 无法继承该方法。
    public String login(String username, String password)
    {
        if ("admin".equals(username) && "123".equals(password))
        {
            System.out.println("登录成功");
            return "loginSuccess";
        }
        else
        {
            System.out.println("登录失败");
            return "error";
        }
    }
}
