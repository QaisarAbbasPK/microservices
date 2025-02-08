package com.qaisarabbas.notification_service.consumer;

import com.qaisarabbas.core_service.util.ConfigConstants;
import com.qaisarabbas.notification_service.model.EmailNotificationDTO;
import com.qaisarabbas.notification_service.services.EmailNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailNotificationConsumer {

    private final EmailNotificationService emailNotificationService;

    @RabbitListener(queues = ConfigConstants.EMAIL_QUEUE_NAME)
    public void receiveEmailNotification(EmailNotificationDTO notification) {
        log.info("📥 Received Email Notification: {}", notification);
        emailNotificationService.saveEmailNotification(notification);
    }
}

