package com.cloud.provider.callback;

import com.cloud.provider.util.MessageRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TxConfirmCallback
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/12 13:29
 */
@Component
public class TxConfirmCallback implements RabbitTemplate.ConfirmCallback {
    private static  Logger logger= LoggerFactory.getLogger(TxConfirmCallback.class);

    @Autowired
    private MessageRetry messageRetry;

    public static boolean SUCCESS_SEND = false;

    @Autowired
    TxConfirmCallback(RabbitTemplate rabbitTemplate){
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.debug("消息发送到exchange成功,id: {}", correlationData.getId());
            SUCCESS_SEND = true;
        } else {
            logger.debug("消息发送到exchange失败,原因: {}", cause);
            messageRetry.reSendMsg();
        }
    }
}
