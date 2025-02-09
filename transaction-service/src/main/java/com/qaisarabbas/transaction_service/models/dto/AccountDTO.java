package com.qaisarabbas.transaction_service.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String accountNumber;
    private String address;
    private String identificationNumber;
    private String profession;
    private String salary;
    private String bankAccountType;
    private String city;
    private String country;
    private boolean active;
}
