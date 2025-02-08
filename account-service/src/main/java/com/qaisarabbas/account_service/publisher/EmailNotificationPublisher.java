package com.qaisarabbas.account_service.publisher;

import com.qaisarabbas.account_service.config.RabbitMQConfig;
import com.qaisarabbas.account_service.model.dto.EmailNotificationDTO;
import com.qaisarabbas.core_service.util.ConfigConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailNotificationPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendEmailNotification(EmailNotificationDTO notification) {
        rabbitTemplate.convertAndSend(
                ConfigConstants.EMAIL_EXCHANGE_NAME,
                ConfigConstants.EMAIL_ROUTING_KEY,
                notification
        );
        log.info(" Email Notification Sent : {}", notification.getEmail());
    }
}

