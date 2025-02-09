package com.qaisarabbas.transaction_service.services;

import com.qaisarabbas.core_service.model.ApiResponse;
import com.qaisarabbas.transaction_service.clients.AccountGrpcClient;
import com.qaisarabbas.transaction_service.grpc.AccountResponse;
import com.qaisarabbas.transaction_service.models.dto.AccountDTO;
import com.qaisarabbas.transaction_service.models.request.SendMoneyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountGrpcClient accountGrpcClient;

    public ApiResponse sendMoney(SendMoneyRequest request) {
        AccountResponse accountResponse = accountGrpcClient.getAccountByNumber(request.getReceiverAccountNumber());
        if (accountResponse == null) {
            return new ApiResponse(400, "Account not found");
        }

        AccountDTO accountDTO = AccountDTO.builder()
                .accountNumber(accountResponse.getAccountNumber())
                .firstName(accountResponse.getFirstName())
                .lastName(accountResponse.getLastName())
                .email(accountResponse.getEmail())
                .phoneNumber(accountResponse.getPhoneNumber())
                .address(accountResponse.getAddress())
                .profession(accountResponse.getProfession())
                .salary(accountResponse.getSalary())
                .bankAccountType(accountResponse.getBankAccountType())
                .city(accountResponse.getCity())
                .country(accountResponse.getCountry())
                .active(accountResponse.getActive())
                .build();

        return new ApiResponse(accountDTO);
    }
}
