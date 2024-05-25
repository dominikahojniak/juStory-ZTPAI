package com.justory.backend.rabbitmq;

import com.justory.backend.api.internal.Users;
import com.justory.backend.repository.UserRepository;
import com.justory.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationConsumer {
    @Value("${app.url}")
    private String appUrl;

    private final EmailService emailService;
    private final UserRepository userRepository;

    public NotificationConsumer(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void receiveNotification(String message) {
        List<Users> users = userRepository.findAll();
        for (Users user : users) {
            String to = user.getEmail();
            String subject = "JUSTORY: Nowe daty premier !!!";
            String body = "Sprawdź nowe premiery książek na najbliższy miesiąc!!";

            emailService.sendSimpleMessage(to, subject, body);
        }
    }
}