package com.brombeer.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.brombeer.integration.ActiveMQConfig.CURRENCY_FMC_TOPIC;
import static com.brombeer.integration.ActiveMQConfig.ORDER_TOPIC;

@Service
public class OrderSender {

    private static Logger log = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendTopic(Order order) {
        log.info("sending with convertAndSend() to queue <" + order + ">");
        jmsTemplate.convertAndSend(ORDER_TOPIC, order);
    }

    public void sendTopic(CurrencyMangement currencyMangement) {
        log.info("sending with convertAndSend() to queue <" + currencyMangement + ">");
        jmsTemplate.convertAndSend(CURRENCY_FMC_TOPIC, currencyMangement);
    }

}
