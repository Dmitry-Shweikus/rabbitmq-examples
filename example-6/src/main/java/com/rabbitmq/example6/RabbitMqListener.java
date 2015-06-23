package com.rabbitmq.example6;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RabbitMqListener {
    Logger logger = Logger.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "query-example-6")
    public String worker1(String message) throws InterruptedException {
        logger.info("Received on worker : " + message);
        Thread.sleep(3000);
        return "Received on worker : " + message;
    }
}
