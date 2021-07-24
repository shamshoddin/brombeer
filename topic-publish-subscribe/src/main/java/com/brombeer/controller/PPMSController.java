package com.brombeer.controller;

import com.brombeer.integration.CurrencyMangement;
import com.brombeer.integration.Order;
import com.brombeer.integration.OrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class PPMSController
{
    private static Logger log = LoggerFactory.getLogger(PPMSController.class);
    @Autowired
    private OrderSender orderSender;

    @GetMapping("/")
    public Order personalProfile()
    {
        log.info("Spring Boot ActiveMQ Publish Subscribe Topic Configuration Example");


            Order order = new Order("ppms", "FlyingProcess", 10, LocalDateTime.now());
            orderSender.sendTopic(order);


        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");


        return order;
    }
    @PostMapping("/add")
    public CurrencyMangement personalProfile(@RequestBody CurrencyMangement currencyMangement)
    {
        log.info("Spring Boot ActiveMQ Publish Subscribe Topic Configuration Example");

       orderSender.sendTopic(currencyMangement);


        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");


        return currencyMangement;
    }
}
