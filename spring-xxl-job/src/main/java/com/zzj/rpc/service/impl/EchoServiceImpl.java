package com.zzj.rpc.service.impl;

import com.zzj.rpc.service.EchoService;

public class EchoServiceImpl implements EchoService
{

    @Override
    public String echo(String ping)
    {
        return ping !=null?ping+"--> I am ok.":"I am bad.";
    }

}
