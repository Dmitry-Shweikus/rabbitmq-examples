package com.rabbitmq.example4;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfiguration {
    Logger logger = Logger.getLogger(RabbitConfiguration.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange("exchange-example-4");
        return rabbitTemplate;
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("query-example-4-1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("query-example-4-2");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("exchange-example-4");
    }

    @Bean
    public Binding errorBinding1(){
        return BindingBuilder.bind(myQueue1()).to(directExchange()).with("error");
    }

    @Bean
    public Binding errorBinding2(){
        return BindingBuilder.bind(myQueue2()).to(directExchange()).with("error");
    }

    @Bean
    public Binding infoBinding(){
        return BindingBuilder.bind(myQueue2()).to(directExchange()).with("info");
    }

    @Bean
    public Binding warningBinding(){
        return BindingBuilder.bind(myQueue2()).to(directExchange()).with("warning");
    }

}
