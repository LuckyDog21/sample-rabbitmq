package com.sample.rabbitmq_service_message.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {
    private final RabbitTemplate template;
    private static int counter = 0;

    public MessageService(RabbitTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedDelay = 1000)
    public void producer() {
        log.debug("producer send");
        if (counter % 10 != 0) {
            template.convertAndSend("topic", "queue.routingKey1", "message1");
        } else {
            template.convertAndSend("topic", "queue.routingKey2", "message2");
        }
        counter += 1;
    }

    @RabbitListener(queues = {"queue.message.first"})
    public void consumer1(String msg) {
        log.debug("Receive for queue1: " + msg);
    }


    @RabbitListener(queues = {"queue.message.second"})
    public void consumer2(String msg) {
        log.debug("Receive for queue2: " + msg);
    }
}
