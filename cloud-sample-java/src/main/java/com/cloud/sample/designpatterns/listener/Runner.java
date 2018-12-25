package com.cloud.sample.designpatterns.listener;

/**
 * @ClassName Runner
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/11/12 17:41
 */
public class Runner {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new ProjectEventListener());
        eventSource.notifyListenerEvents(new ProjectEvent("add project"));
    }
}
