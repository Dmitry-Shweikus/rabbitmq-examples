package com.rabbitmq.example6;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/process/{message}")
    @ResponseBody
    String error(@PathVariable("message") String message) {
        logger.info(String.format("Emit '%s'",message));
        String response = (String) template.convertSendAndReceive("query-example-6",message);
        logger.info(String.format("Received on producer '%s'",response));
        return String.valueOf("returned from worker : " + response);
    }
}