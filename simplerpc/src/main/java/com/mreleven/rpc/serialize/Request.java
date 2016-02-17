package com.mreleven.rpc.serialize;

import java.io.Serializable;

/**
 * 方法调用的请求报文对象
 * Created by huiyao on 16-2-15.
 */
public class Request implements Serializable{
    private Class clazz;
    private String method;
    private Object param;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Object invoke(Object bean) throws Exception {
        return clazz.getMethod(method, param.getClass()).invoke(bean, param);
    }

    @Override
    public String toString() {
        return "Request{" +
                "clazz=" + clazz +
                ", method='" + method + '\'' +
                ", param=" + param +
                '}';
    }
}
