package com.mreleven.rpc;

import com.alibaba.fastjson.JSON;
import com.mreleven.rpc.serialize.Request;
import com.mreleven.rpc.serialize.json.JsonFormater;
import org.springframework.stereotype.Component;

import com.mreleven.rpc.proxy.ProviderProxyFactory;

/**
 * Created by version_z on 2015/8/22.
 */
@Component("speakInterface")
public class SpeakInterfaceImpl implements SpeakInterface
{
    public String speak(People people)
    {
        if (people.getAge() > 18)
        {
            if (people.getSex() == 0)
            {
                return "男 "+people.getAge()+"岁";
            }else
            {
                return "女  "+people.getAge()+"岁";
            }
        }
        else
        {
            return "燃烧吧，玉米同学。";
        }
    }
}
