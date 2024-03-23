package fiipractic.PFM_TRX_MGM.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record CategoryDto(
        @NotNull String value,
        BigInteger parentId
) {
}
