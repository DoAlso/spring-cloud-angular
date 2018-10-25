//package com.cloud.provider.callback;
//
//
//import com.cloud.provider.sender.MessageRetry;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName TxReturnCallback
// * @Description TODO
// * @Author Administrator
// * @DATE 2018/10/12 13:35
// */
//@Component
//public class TxReturnCallback implements RabbitTemplate.ReturnCallback {
//
//    private static Logger logger= LoggerFactory.getLogger(TxReturnCallback.class);
//
//    @Autowired
//    private MessageRetry messageRetry;
//
//    @Autowired
//    TxReturnCallback(RabbitTemplate rabbitTemplate){
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        rabbitTemplate.setReturnCallback(this);
//    }
//
//    @Override
//    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//        String correlationId = message.getMessageProperties().getCorrelationId();
//        logger.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
//        messageRetry.reSendMsg();
//    }
//}
