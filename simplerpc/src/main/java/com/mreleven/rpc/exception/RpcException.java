package com.mreleven.rpc.exception;

/**
 * Created by huiyao on 16-2-15.
 */
public class RpcException extends Throwable {
    private String code;

    private Object data;

    public RpcException(String message, Throwable cause, String code, Object data) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public RpcException(String code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }
    public Object getData() {
        return data;
    }
}
