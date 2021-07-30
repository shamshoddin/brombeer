package com.brombeer.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.jms.Session;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class OrderConsumer {

    private static Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @JmsListener(destination = ActiveMQConfig.ORDER_TOPIC, containerFactory = "topicListenerFactory")
    public void receiveTopicMessage(@Payload Order order,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {

        log.info("received <" + order + ">");
    }
    //listener for ppms and once recieve the message and it will trigger to the ppms end point
    @JmsListener(destination = ActiveMQConfig.CURRENCY_FMC_TOPIC, containerFactory = "topicListenerFactory")
    public void receiveTopicMessage(@Payload CurrencyMangement currencyMangement,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {


        //Send location in response
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:9092/ppms/add";
        System.out.println("url :"+baseUrl);
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ResponseEntity<String> result = restTemplate.postForEntity(uri, currencyMangement, String.class);
        System.out.println("result :"+result);


        log.info("received <" + currencyMangement + ">");
    }

}
