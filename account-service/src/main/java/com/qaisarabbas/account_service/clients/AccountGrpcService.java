package com.qaisarabbas.account_service.clients;

import com.qaisarabbas.account_service.entities.Accounts;
import com.qaisarabbas.account_service.repositories.AccountsRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.qaisarabbas.account_service.grpc.AccountServiceGrpc;
import com.qaisarabbas.account_service.grpc.AccountResponse;
import com.qaisarabbas.account_service.grpc.AccountRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountGrpcService extends AccountServiceGrpc.AccountServiceImplBase {

    private final AccountsRepository accountsRepository;

    @Override
    public void getAccountByNumber(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        String accountNumber = request.getAccountNumber();

        Optional<Accounts> accountOpt = accountsRepository.findByAccountNumber(accountNumber);

        if (accountOpt.isEmpty()) {
            responseObserver.onError(new RuntimeException("Account not found"));
            return;
        }

        Accounts account = accountOpt.get();
        AccountResponse response = AccountResponse.newBuilder()
                .setFirstName(account.getFirstName())
                .setLastName(account.getLastName())
                .setEmail(account.getEmail())
                .setPhoneNumber(account.getPhoneNumber())
                .setAccountNumber(account.getAccountNumber())
                .setAddress(account.getAddress())
                .setIdentificationNumber(account.getIdentificationNumber())
                .setProfession(account.getProfession())
                .setSalary(account.getSalary())
                .setBankAccountType(account.getBankAccountType())
                .setCity(account.getCity())
                .setCountry(account.getCountry())
                .setActive(account.isActive())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
