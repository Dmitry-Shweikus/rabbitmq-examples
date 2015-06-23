package com.rabbitmq.example4;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    Logger logger = Logger.getLogger(SampleController.class);

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

    @RequestMapping("/emit/error")
    @ResponseBody
    String error() {
        logger.info("Emit as error");
        template.convertAndSend("error", "Error");
        return "Emit as error";
    }

    @RequestMapping("/emit/info")
    @ResponseBody
    String info() {
        logger.info("Emit as info");
        template.convertAndSend("info", "Info");
        return "Emit as info";
    }

    @RequestMapping("/emit/warning")
    @ResponseBody
    String warning() {
        logger.info("Emit as warning");
        template.convertAndSend("warning", "Warning");
        return "Emit as warning";
    }
}