package fiipractic.PFM_TRX_MGM.service;

import fiipractic.PFM_TRX_MGM.exceptions.NotFoundException;
import fiipractic.PFM_TRX_MGM.model.Transaction;
import fiipractic.PFM_TRX_MGM.repository.TransactionRepo;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TransactionService {

    TransactionRepo transactionRepo;

    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }

    public Transaction getById(BigInteger id) {
        return transactionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Transaction with ID: " + id + " not found."));
    }

    public Transaction save(Transaction transaction) {
        return transactionRepo.save(transaction);
    }
}
