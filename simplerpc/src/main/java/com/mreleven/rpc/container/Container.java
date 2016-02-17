package com.mreleven.rpc.container;

/**
 * Created by huiyao on 16-2-15.
 */
public abstract class Container {
    public static volatile boolean isStart = false;

    public abstract void start();

    public static volatile Container container = null;
}
