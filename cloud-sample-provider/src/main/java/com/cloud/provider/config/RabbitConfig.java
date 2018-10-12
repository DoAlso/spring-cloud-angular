package com.cloud.provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    /**
     * 创建派工队列
     * @return
     */
    @Bean
    public Queue topicDispatchQueue() {
        return new Queue("topic.dispatch");
    }


    /**
     * 创建报警消息队列
     * @return
     */
    @Bean
    public Queue topicAlarmQueue() {
        return new Queue("topic.alarm");
    }


    /**
     * 创建交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }


    /**
     * 绑定交换机和相应的队列
     * @param topicDispatchQueue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeTopicDispatch(Queue topicDispatchQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicDispatchQueue).to(topicExchange).with("topic.dispatch");
    }


    /**
     * 绑定交换机和相应的队列
     * @param topicAlarmQueue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeTopicAlarm(Queue topicAlarmQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicAlarmQueue).to(topicExchange).with("topic.alarm");
    }

}
