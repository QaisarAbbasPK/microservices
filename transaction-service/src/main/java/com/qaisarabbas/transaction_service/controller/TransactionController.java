package com.qaisarabbas.transaction_service.controller;

import com.qaisarabbas.core_service.model.ApiResponse;
import com.qaisarabbas.transaction_service.models.request.SendMoneyRequest;
import com.qaisarabbas.transaction_service.services.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transaction")
class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("send-money")
    ResponseEntity<ApiResponse> sendMoney(@RequestBody SendMoneyRequest request) {
        log.info("Creating transaction...");
        return ResponseEntity.ok(transactionService.sendMoney(request));
    }
}
