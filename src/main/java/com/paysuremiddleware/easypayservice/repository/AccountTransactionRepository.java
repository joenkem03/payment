package com.paysuremiddleware.easypayservice.repository;

import com.paysuremiddleware.easypayservice.models.AccountTransactionEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransactionEntry, Long> {
    AccountTransactionEntry findByRequestId(String requestId);

}
