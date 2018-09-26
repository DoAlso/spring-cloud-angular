package com.txmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /** 业务交换器名称 **/
    private static final String BUSINESS_EXCHANGE = "business.exchange";
    /** 业务对列的名称 **/
    public static final String BUSINESS_QUEUE = "business.queue";
    /** 业务key的名称 **/
    public static final String BUSINESS_KEY = "business.key";


    @Bean
    public Queue businessQueue(){
        return new Queue(BUSINESS_QUEUE);
    }


    /**
     * 创建交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(BUSINESS_EXCHANGE);
    }


    /**
     *
     * @param businessQueue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeBusinessQueue(Queue businessQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(businessQueue).to(topicExchange).with(BUSINESS_KEY);
    }
}
