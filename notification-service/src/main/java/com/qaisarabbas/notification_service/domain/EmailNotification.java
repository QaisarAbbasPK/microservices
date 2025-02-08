package com.qaisarabbas.notification_service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email_notifications")
public class EmailNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankAccountNumber;
    private String email;
    private String messageType;
    private String message;
    private boolean sent;
    private String ipAddress;
    private LocalDateTime createdAt;
}
