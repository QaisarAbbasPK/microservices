package com.qaisarabbas.account_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers_account")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String accountNumber;
    private String address;
    private String identificationNumber;
    private String profession;
    private String salary;
    private String bankAccountType;
    private String city;
    private String country;
    private boolean active;
    private LocalDateTime createdAt;
}
