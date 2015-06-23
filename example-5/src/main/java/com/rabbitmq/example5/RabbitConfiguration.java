package com.rabbitmq.example5;

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
        rabbitTemplate.setExchange("exchange-example-5");
        return rabbitTemplate;
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("query-example-5-1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("query-example-5-2");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("exchange-example-5");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(topicExchange()).with("*.orange.*");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("*.*.rabbit");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("lazy.#");
    }
}
