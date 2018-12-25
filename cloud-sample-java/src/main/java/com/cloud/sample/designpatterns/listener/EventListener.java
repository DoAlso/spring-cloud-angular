package com.cloud.sample.designpatterns.listener;


import java.util.EventObject;

/**
 * @ClassName EventListener
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/11/12 16:58
 */
public interface EventListener extends java.util.EventListener {

    /**
     * @param event
     * 处理被监听的事件
     */
    void handleEvent(EventObject event);
}
