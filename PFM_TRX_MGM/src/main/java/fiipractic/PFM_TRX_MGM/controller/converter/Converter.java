package fiipractic.PFM_TRX_MGM.controller.converter;

import fiipractic.PFM_TRX_MGM.dto.TransactionDto;
import fiipractic.PFM_TRX_MGM.model.Transaction;

public class Converter {
    public static Transaction convertToEntity(TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.amount(),
                transactionDto.categoryId(),
                transactionDto.keywordId(),
                transactionDto.parentId(),
                transactionDto.description()
        );
    }
}
