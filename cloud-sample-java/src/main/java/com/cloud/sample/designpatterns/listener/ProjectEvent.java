package com.cloud.sample.designpatterns.listener;

import java.util.EventObject;

/**
 * @ClassName ProjectEvent
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/11/12 17:27
 */
public class ProjectEvent extends EventObject {

    public ProjectEvent(Object source) {
        super(source);
    }

    public void doEvent(){
        System.out.println("通知一个事件源 source : "+this.getSource());
    }
}
