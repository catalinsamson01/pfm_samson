package fiipractic.PFM_TRX_MGM.controller;

import fiipractic.PFM_TRX_MGM.controller.converter.Converter;
import fiipractic.PFM_TRX_MGM.dto.TransactionDto;
import fiipractic.PFM_TRX_MGM.model.Transaction;
import fiipractic.PFM_TRX_MGM.service.CategoryService;
import fiipractic.PFM_TRX_MGM.service.KeywordService;
import fiipractic.PFM_TRX_MGM.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final CategoryService categoryService;
    private final KeywordService keywordService;

    public TransactionController(TransactionService transactionService, CategoryService categoryService, KeywordService keywordService) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
        this.keywordService = keywordService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll() {
        List<Transaction> transactions = transactionService.getAll();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable BigInteger id) {
        Transaction transaction = transactionService.getById(id);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody TransactionDto transactionDto) {

        // validate ids
        if (transactionDto.categoryId() != null)
            categoryService.getById(transactionDto.categoryId());
        if (transactionDto.keywordId() != null)
            keywordService.getById(transactionDto.keywordId());
        if (transactionDto.parentId() != null)
            transactionService.getById(transactionDto.parentId());

        Transaction transaction = Converter.convertToEntity(transactionDto);
        Transaction savedTransaction = transactionService.save(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

}
