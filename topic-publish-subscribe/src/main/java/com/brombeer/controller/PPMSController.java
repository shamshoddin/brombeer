package com.brombeer.controller;

import com.brombeer.integration.Order;
import com.brombeer.integration.OrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PPMSController
{
    private static Logger log = LoggerFactory.getLogger(PPMSController.class);
    @Autowired
    private OrderSender orderSender;

    @RequestMapping("/")
    public Order personalProfile()
    {
        log.info("Spring Boot ActiveMQ Publish Subscribe Topic Configuration Example");


            Order order = new Order("ppms", "FlyingProcess", 10, LocalDateTime.now());
            orderSender.sendTopic(order);


        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");


        return order;
    }
}
