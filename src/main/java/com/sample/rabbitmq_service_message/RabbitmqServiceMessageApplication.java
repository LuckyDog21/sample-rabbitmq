package com.sample.rabbitmq_service_message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqServiceMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServiceMessageApplication.class, args);
    }

}
