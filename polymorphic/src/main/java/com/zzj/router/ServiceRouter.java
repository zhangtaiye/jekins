package com.zzj.router;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zzj.service.PaymentTypeService;

@Component
public class ServiceRouter implements InitializingBean {

    private static final Map<String, PaymentTypeService> routerMap = new HashMap<String, PaymentTypeService>();

    @Autowired
    private List<PaymentTypeService> iServiceList;

    @Override
    public void afterPropertiesSet() throws Exception {
        for (PaymentTypeService service : iServiceList) {
            routerMap.put(service.type(), service);
        }
    }

    public PaymentTypeService getService(String type) {
        return routerMap.get(type);
    }
}