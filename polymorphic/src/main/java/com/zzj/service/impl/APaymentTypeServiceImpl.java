package com.zzj.service.impl;

import org.springframework.stereotype.Service;

import com.zzj.service.PaymentTypeService;

/**
 * 支付方式A实现类
 * @date: 2018年4月23日 下午2:20:27
 */
@Service
public class APaymentTypeServiceImpl implements PaymentTypeService {
 
    private final String type = "A";
    
    @Override
    public void methodA() {
        // TODO Auto-generated method stub
        System.out.println("APaymentTypeServiceImpl A invoke methodA");
    }
 
    @Override
    public void methodB() {
        // TODO Auto-generated method stub
        System.out.println("APaymentTypeServiceImpl A invoke methodB");
    }
 
    @Override
    public String type() {
        return type;
    }
 
}
