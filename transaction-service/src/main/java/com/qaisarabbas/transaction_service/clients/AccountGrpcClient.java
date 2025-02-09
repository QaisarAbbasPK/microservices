package com.qaisarabbas.transaction_service.clients;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.qaisarabbas.transaction_service.grpc.AccountServiceGrpc;
import com.qaisarabbas.transaction_service.grpc.AccountResponse;
import com.qaisarabbas.transaction_service.grpc.AccountRequest;

@Service
@RequiredArgsConstructor
public class AccountGrpcClient {

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7001)
            .usePlaintext()
            .build();

    private final AccountServiceGrpc.AccountServiceBlockingStub stub = AccountServiceGrpc.newBlockingStub(channel);

    public AccountResponse getAccountByNumber(String accountNumber) {
        AccountRequest request = AccountRequest.newBuilder().setAccountNumber(accountNumber).build();
        return stub.getAccountByNumber(request);
    }
}

