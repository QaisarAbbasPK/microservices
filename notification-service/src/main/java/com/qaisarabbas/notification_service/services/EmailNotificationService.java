package com.qaisarabbas.notification_service.services;

import com.qaisarabbas.notification_service.domain.EmailNotification;
import com.qaisarabbas.notification_service.model.EmailNotificationDTO;
import com.qaisarabbas.notification_service.repositories.EmailNotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailNotificationService {

    private final EmailNotificationRepository emailNotificationRepository;
    private final JavaMailSender javaMailSender;

    public void saveEmailNotification(EmailNotificationDTO notification) {

        //Send Email
        sendEmail(notification.getEmail(), "Dear Customer your Bank Account is Created", notification.getMessage());

        EmailNotification emailNotification = EmailNotification.builder()
                .bankAccountNumber(notification.getBankAccountNumber())
                .email(notification.getEmail())
                .messageType(notification.getMessageType())
                .message(notification.getMessage())
                .sent(true)
                .ipAddress(notification.getIpAddress())
                .createdAt(LocalDateTime.now())
                .build();
        emailNotificationRepository.save(emailNotification);
        log.info("Email Notification saved: {}", emailNotification.getId());
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }
}
