package com.qaisarabbas.account_service.repositories;

import com.qaisarabbas.account_service.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByAccountNumber(String accountNumber);
}
