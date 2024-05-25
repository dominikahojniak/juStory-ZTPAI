package com.justory.backend.rabbitmq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class ScheduledTask {
    private boolean emailSent = false;
    @Autowired
    private NotificationProducer notificationProducer;

    @Scheduled(cron = "0 0 0 1 * ?") //sekundy, minuty, godziny, dzien miesiaca, miesiac, dzien tygodnia
    public void sendMonthlyEmailNotifications() {
        if (!emailSent) {
            String message = "Nowe premiery zostały dodane!";
            notificationProducer.sendNotification(message);
            System.out.println("Sending monthly email notifications...");
            emailSent = true;
        }
    }
}