package com.yxp.messagebus;

import java.util.HashMap;

/**
 * Created by yanxing on 16/1/4.
 */
public class MessageBus {
    public HashMap<String, Object> messageList = new HashMap<>();

    public void register(Object subscriber) {

    }

    public void unregister(Object subscriber) {

    }

    public void post(Message msg) {

    }
}
