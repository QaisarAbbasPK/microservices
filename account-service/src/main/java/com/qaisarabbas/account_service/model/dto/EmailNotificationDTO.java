package com.qaisarabbas.account_service.model.dto;

import lombok.*;

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
