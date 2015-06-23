package com.rabbitmq.example1annotated;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by dshv on 22.06.2015.
 */
@EnableAutoConfiguration
@Import(RabbitConfiguration.class)
@ComponentScan(basePackages = "com.rabbitmq.example1annotated")
public class Example1AnnotatedConfiguration {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example1AnnotatedConfiguration.class, args);
    }
}
