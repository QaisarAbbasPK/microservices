package com.qaisarabbas.account_service.services;

import com.qaisarabbas.account_service.entities.Accounts;
import com.qaisarabbas.account_service.model.dto.EmailNotificationDTO;
import com.qaisarabbas.account_service.model.requests.CreateAccountRequest;
import com.qaisarabbas.account_service.publisher.EmailNotificationPublisher;
import com.qaisarabbas.account_service.repositories.AccountsRepository;
import com.qaisarabbas.core_service.model.ApiResponse;
import com.qaisarabbas.core_service.util.ApiStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountsRepository accountRepository;
    private final EmailNotificationPublisher emailNotificationPublisher;

    public ApiResponse createAccount(CreateAccountRequest request) {
        Accounts account = Accounts.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .accountNumber(generateAccountNumber())
                .address(request.getAddress())
                .identificationNumber(request.getIdentificationNumber())
                .profession(request.getProfession())
                .salary(request.getSalary())
                .bankAccountType(request.getBankAccountType())
                .city(request.getCity())
                .country(request.getCountry())
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();
        accountRepository.save(account);
        log.info("AccountService::createAccount() => Account Created : {}", account);

        //Send Email Notification
        emailNotificationPublisher.sendEmailNotification(EmailNotificationDTO.builder()
                .bankAccountNumber(account.getAccountNumber())
                .email(account.getEmail())
                .messageType("ACCOUNT-CREATED")
                .message("Account Created Successfully")
                .ipAddress("127.0.0.1")
                .build());

        return new ApiResponse(account);
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append(random.nextInt(9) + 1);
        for (int i = 1; i < 10; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    public ApiResponse fetchAccount(String accountNumber) {
        Optional<Accounts> accounts = accountRepository.findByAccountNumber(accountNumber);
        if (accounts.isEmpty()) {
            log.error("AccountService::fetchAccount() => Account Not Found : {}", accountNumber);
            return new ApiResponse(ApiStatus.NOT_FOUND, "Account Not Found");
        }
        log.info("AccountService::fetchAccount() => Account Found : {}", accountNumber);
        return new ApiResponse(accountRepository.findByAccountNumber(accountNumber));
    }
}
