package com.brombeer.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.brombeer.*"})
public class Run {//implements ApplicationRunner {

    private static Logger log = LoggerFactory.getLogger(Run.class);
/*
    @Autowired
    private OrderSender orderSender;*/

 /*   @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring Boot ActiveMQ Publish Subscribe Topic Configuration Example");

        for (int i = 0; i < 5; i++){
            Order order = new Order("me", "you", new BigDecimal(i), LocalDateTime.now());
            orderSender.sendTopic(order);
        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }
}
