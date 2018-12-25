package com.cloud.sample.designpatterns.listener;

import java.util.EventObject;

/**
 * @ClassName ProjectEventListener
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/11/12 17:42
 */
public class ProjectEventListener implements EventListener {

    @Override
    public void handleEvent(EventObject event) {
        System.out.println("监控到项目添加事件");
    }
}
