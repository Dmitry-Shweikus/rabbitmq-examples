package com.rabbitmq.example1annotated;

        import org.apache.log4j.Logger;
        import org.springframework.amqp.rabbit.annotation.EnableRabbit;
        import org.springframework.amqp.rabbit.annotation.RabbitListener;
        import org.springframework.stereotype.Component;

/**
 * Created by dshv on 22.06.2015.
 */
@EnableRabbit
@Component
public class RabbitMqListener {
    Logger logger = Logger.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        logger.info("Received from queue 1: " + message);
    }

}
