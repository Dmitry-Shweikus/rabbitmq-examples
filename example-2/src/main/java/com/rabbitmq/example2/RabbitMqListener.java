package com.rabbitmq.example2;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RabbitMqListener {
    Logger logger = Logger.getLogger(RabbitMqListener.class);
    Random random = new Random();

    @RabbitListener(queues = "query-example-2")
    public void worker1(String message) throws InterruptedException {
        logger.info("worker 1 : " + message);
        Thread.sleep(100 * random.nextInt(20));
    }

    @RabbitListener(queues = "query-example-2")
    public void worker2(String message) throws InterruptedException {
        logger.info("worker 2 : " + message);
        Thread.sleep(100 * random.nextInt(20));
    }

}
