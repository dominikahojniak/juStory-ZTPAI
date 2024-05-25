package com.justory.backend.rabbitmq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOTIFICATION_QUEUE, message);
    }
}