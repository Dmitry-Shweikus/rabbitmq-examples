package com.rabbitmq.example5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan
@Import(RabbitConfiguration.class)
public class Configuration {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Configuration.class, args);
    }

}
