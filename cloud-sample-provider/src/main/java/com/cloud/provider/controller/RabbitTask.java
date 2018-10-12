//package com.cloud.provider.controller;
//
//import com.cloud.provider.util.Sender;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName RabbitTask
// * @Description TODO
// * @Author Administrator
// * @DATE 2018/10/12 15:12
// */
//@Component
//public class RabbitTask {
//
//    @Autowired
//    private Sender sender;
//
//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        System.out.println("测试定时任务");
//    }
//
//    @Scheduled(fixedRate = 1000)
//    public void sendMsg(){
//        System.out.println("-------------RabbitMQ------------");
//        sender.send();
//        System.out.println("----------------END-----------------");
//    }
//}
