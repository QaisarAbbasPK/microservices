package com.qaisarabbas.transaction_service.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SendMoneyRequest {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private double amount;
}
