package com.qaisarabbas.transaction_service.services;

import com.qaisarabbas.core_service.model.ApiResponse;
import com.qaisarabbas.transaction_service.models.request.SendMoneyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService {
    public ApiResponse sendMoney(SendMoneyRequest request) {
        return new ApiResponse(request);
    }
}
