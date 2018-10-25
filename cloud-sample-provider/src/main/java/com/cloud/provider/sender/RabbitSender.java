package com.cloud.provider.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RabbitSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback, InitializingBean {
    private final Logger logger = LoggerFactory.getLogger(RabbitSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // 消息回调确认失败处理
        if (!ack) {
            // 这里以做消息的从发等处理
            logger.info("消息发送失败，消息ID:{}", correlationData.getId());
        } else {
            logger.info("消息发送成功,消息ID:{}", correlationData.getId());
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.error("MQ消息发送失败，replyCode:{}, replyText:{}，exchange:{}，routingKey:{}，消息体:{}",
                replyCode, replyText, exchange, routingKey, new String(message.getBody()));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    public void send() {
        String msgId = UUID.randomUUID().toString();
        //消息发送的前置处理器，将发送的消息包装上唯一的ID
        //当消息通过routingKey路由失败后可以通过该消息ID做出响应的处理
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {

            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setCorrelationId(msgId);
                // 设置消息持久化
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        };
        MessageProperties messageProperties = new MessageProperties();
        Message message = new Message("Hello,RabbitMQ".getBytes(),messageProperties);
        this.redisTemplate.opsForHash().put("mq.producer.retry.key", msgId, "");
        this.rabbitTemplate.convertAndSend("topicExchange","topic.dispatch1", message,messagePostProcessor,new CorrelationData(msgId));
    }
}
