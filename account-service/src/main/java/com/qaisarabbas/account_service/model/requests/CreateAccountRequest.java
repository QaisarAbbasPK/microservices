package com.qaisarabbas.account_service.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String identificationNumber;
    private String profession;
    private String salary;
    private String bankAccountType;
    private String city;
    private String country;
}

