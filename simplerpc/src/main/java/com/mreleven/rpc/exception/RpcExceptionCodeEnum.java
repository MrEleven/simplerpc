package com.mreleven.rpc.exception;

/**
 * Created by huiyao on 16-2-15.
 */
public enum  RpcExceptionCodeEnum {

    DATA_PARSER_ERROR("DATA_PARSER_ERROR","Êý¾Ý×ª»»Òì³£"),
    NO_BEAN_FOUND("NO_BEAN_FOUND","Ã»ÓÐÕÒµ½bean¶ÔÏó"),
    INVOKE_REQUEST_ERROR("INVOKE_REQUEST_ERROR","RPCÇëÇóÒì³£"),
    ;

    private String code;
    private String msg;

    RpcExceptionCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
