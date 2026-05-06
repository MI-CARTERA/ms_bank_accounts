package com.MiCartera.msbankaccounts.bankAccount.infrastructure;

import com.MiCartera.msbankaccounts.bankAccount.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}