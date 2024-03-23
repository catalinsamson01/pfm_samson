package fiipractic.PFM_TRX_MGM.repository;


import fiipractic.PFM_TRX_MGM.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    Optional<Transaction> findById(BigInteger id);
}
