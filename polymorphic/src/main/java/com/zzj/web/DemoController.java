package com.zzj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzj.router.ServiceRouter;
import com.zzj.service.PaymentTypeService;

@Controller
public class DemoController
{

    @Autowired
    private ServiceRouter router; 
   

    /**
     * 请求某个支付方式
     * @date: 2018年4月23日 下午2:21:28 
     * @param type
     */
    @RequestMapping(value = "/test/{type}", method = RequestMethod.GET)
    @ResponseBody
    public String test(@PathVariable("type") String type)
    {
        // 获取该支付方式实现类
        PaymentTypeService ap=router.getService(type);
        ap.methodA();
        ap.methodB();
        return "ggg";
    }

}