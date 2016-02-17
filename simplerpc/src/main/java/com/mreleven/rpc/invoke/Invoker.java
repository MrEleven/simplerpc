package com.mreleven.rpc.invoke;

import com.mreleven.rpc.exception.RpcException;

import java.io.OutputStream;

/**
 * rpc调用与响应报文传输接口
 * Created by huiyao on 16-2-15.
 */
public interface Invoker {

    String request(String request, ConsumerConfig consumerConfig) throws RpcException;

    void response(String response, OutputStream outputStream) throws RpcException;
}
