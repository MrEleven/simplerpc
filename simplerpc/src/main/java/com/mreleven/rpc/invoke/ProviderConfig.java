package com.mreleven.rpc.invoke;

/**
 * Created by huiyao on 16-2-15.
 */
public class ProviderConfig {
    private String target;
    private Integer port;

    public ProviderConfig() {

    }

    public ProviderConfig(String target, Integer port) {
        this.target = target;
        this.port = port;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
