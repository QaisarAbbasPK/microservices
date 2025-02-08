package com.qaisarabbas.account_service.controllers;

import com.qaisarabbas.account_service.model.requests.CreateAccountRequest;
import com.qaisarabbas.account_service.services.AccountService;
import com.qaisarabbas.core_service.model.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
class AccountController {

    private final AccountService accountService;

    @PostMapping("create")
    ResponseEntity<ApiResponse> createAccount(@RequestBody CreateAccountRequest request) {
        log.info("AccountController::createAccount() => Create Account Parameters : {}", request.getIdentificationNumber());
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @GetMapping("fetch/{accountNumber}")
    ResponseEntity<ApiResponse> fetchAccount(@PathVariable String accountNumber) {
        log.info("AccountController::fetchAccount() => Fetch Account Parameters : {}", accountNumber);
        return ResponseEntity.ok(accountService.fetchAccount(accountNumber));
    }
}
