package fiipractic.PFM_TRX_MGM.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record TransactionDto (
    @NotNull Double amount,
    BigInteger categoryId,
    BigInteger keywordId,
    BigInteger parentId,
    String description
){
}
