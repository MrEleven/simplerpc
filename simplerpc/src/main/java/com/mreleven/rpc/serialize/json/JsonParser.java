package com.mreleven.rpc.serialize.json;

import com.alibaba.fastjson.JSON;
import com.mreleven.rpc.exception.RpcException;
import com.mreleven.rpc.exception.RpcExceptionCodeEnum;
import com.mreleven.rpc.serialize.Parser;
import com.mreleven.rpc.serialize.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huiyao on 16-2-15.
 */
public class JsonParser implements Parser{
    private static final Logger logger = LoggerFactory.getLogger(JsonParser.class);

    public static final Parser parser = new JsonParser();

    public Request reqParse(String param) throws RpcException {
        try {
            logger.debug("调用参数 {}", param);
            return (Request) JSON.parse(param);
        }
        catch (Exception e) {
            logger.error("转换异常 param = {}", param, e);
            throw new RpcException("", e, RpcExceptionCodeEnum.DATA_PARSER_ERROR.getCode(), param);
        }
    }

    public <T> T rsbParse(String result) {
        return (T)JSON.parse(result);
    }
}
