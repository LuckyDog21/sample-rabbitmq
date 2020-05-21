package com.sample.rabbitmq_service_message;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    Queue queue1() {
        return new Queue("queue.message.first", false);
    }


    @Bean
    Queue queue2() {
        return new Queue("queue.message.second", false);
    }

    @Bean
    TopicExchange topic() {
        return new TopicExchange("topic");
    }

    @Bean
    Binding binding1(Queue queue1, TopicExchange topic) {
        return BindingBuilder.bind(queue1).to(topic).with("queue.routingKey1");
    }


    @Bean
    Binding binding2(Queue queue2, TopicExchange topic) {
        return BindingBuilder.bind(queue2).to(topic).with("queue.routingKey2");
    }
}
