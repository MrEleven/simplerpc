package com.mreleven.rpc.serialize;

import com.mreleven.rpc.exception.RpcException;

/**
 * Created by huiyao on 16-2-15.
 */
public interface Parser {
    /**
     * 将请求反序列化
     * @param param
     * @return
     * @throws RpcException
     */
    Request reqParse(String param) throws RpcException;

    /**
     * 将响应反序列化
     * @param result
     * @param <T>
     * @return
     */
    public <T> T rsbParse(String result);
}
