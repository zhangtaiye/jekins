package com.zzj.service.impl;

import org.springframework.stereotype.Service;

import com.zzj.service.UserService;

//实现类，到此为止和静态代理是一模一样的。
@Service("userService")
public class UserServiceImpl implements UserService
{
    // JDK的动态代理必须要有接口，这是和cglib最大不同的地方
    @Override
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