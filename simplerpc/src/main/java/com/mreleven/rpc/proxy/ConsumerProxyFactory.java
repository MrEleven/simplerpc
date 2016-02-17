package com.mreleven.rpc.proxy;

import com.mreleven.rpc.invoke.ConsumerConfig;
import com.mreleven.rpc.invoke.HttpInvoker;
import com.mreleven.rpc.invoke.Invoker;
import com.mreleven.rpc.serialize.Formater;
import com.mreleven.rpc.serialize.Parser;
import com.mreleven.rpc.serialize.json.JsonFormater;
import com.mreleven.rpc.serialize.json.JsonParser;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by huiyao on 16-2-15.
 */
public class ConsumerProxyFactory implements InvocationHandler{
    private ConsumerConfig consumerConfig;

    private Parser parser = JsonParser.parser;

    private Formater formater = JsonFormater.formater;

    private Invoker invoker = HttpInvoker.invoker;

    private String clazz;

    public Object create() throws Exception {
        Class interfaceClass = Class.forName(clazz);
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, this);
    }

    public ConsumerConfig getConsumerConfig() {
        return consumerConfig;
    }

    public void setConsumerConfig(ConsumerConfig consumerConfig) {
        this.consumerConfig = consumerConfig;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Formater getFormater() {
        return formater;
    }

    public void setFormater(Formater formater) {
        this.formater = formater;
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class interfaceClass = proxy.getClass().getInterfaces()[0];
        String req = formater.reqFormat(interfaceClass, method.getName(), args[0]);
        String resb = invoker.request(req, consumerConfig);
        return parser.rsbParse(resb);
    }
}
