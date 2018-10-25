//package com.cloud.provider.sender;
//
//import com.cloud.provider.callback.TxConfirmCallback;
//import com.github.rholder.retry.*;
//import com.google.common.base.Predicates;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.sender.concurrent.Callable;
//import java.sender.concurrent.TimeUnit;
//
///**
// * @ClassName MessageRetry
// * @Description TODO
// * @Author Administrator
// * @DATE 2018/10/12 17:18
// */
//@Component
//public class MessageRetry {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//    /**
//     * 重发消息
//     */
//    public void reSendMsg() {
//
//        class ReSendThread implements Callable {
//
//            @Override
//            public Boolean call() throws Exception {
//                System.out.println("重新发送.....");
//                if(TxConfirmCallback.SUCCESS_SEND){
//                    return true;
//                }
//                rabbitTemplate.convertAndSend("topicExchange","topic.dispatch1", "Hello ,World");
//                System.out.println(".....END.....");
//                return false;
//            }
//        }
//
//        Retryer<Boolean> retryer = RetryerBuilder
//                .<Boolean>newBuilder()
//                //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
//                .retryIfException()
//                .retryIfResult(Predicates.equalTo(false))
//                //重试策略  100ms*2^n 最多10s
//                .withWaitStrategy(WaitStrategies.exponentialWait(500,
//                       10, TimeUnit.SECONDS))
//                .withStopStrategy(StopStrategies.stopAfterAttempt(2))
//                .withRetryListener(new TxRetryListener<>())
//                .build();
//
//        ReSendThread reSendThread = new ReSendThread();
//        try {
//            retryer.call(reSendThread);
//            //未发送成功，入死信队列
//            if(!TxConfirmCallback.SUCCESS_SEND) {
//                //消息入死信队列
//                System.out.println("消息进入死信");
//            }
//        } catch (Exception e) {
//            System.out.println("重发消息异常");
//        }
//    }
//}
