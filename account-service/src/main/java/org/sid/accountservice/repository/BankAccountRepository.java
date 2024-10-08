package org.sid.accountservice.repository;

import org.sid.accountservice.entiities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
