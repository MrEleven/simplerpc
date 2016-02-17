package com.mreleven.rpc.serialize;

/**
 * Created by huiyao on 16-2-15.
 */
public interface Formater {
    /**
     * 将请求序列化
     * @param clazz 请求的接口
     * @param method 请求的方法
     * @param param 请求的参数
     * @return
     */
    String reqFormat(Class clazz, String method, Object param);

    /**
     * 将相应序列化
     * @param param
     * @return
     */
    String rsbFormat(Object param);
}
