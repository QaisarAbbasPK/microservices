package com.qaisarabbas.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotificationDTO {
    private String bankAccountNumber;
    private String email;
    private String messageType;
    private String message;
    private String ipAddress;
}
