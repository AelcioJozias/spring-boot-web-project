package com.jozias.api.dtos.input;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record CreateTransactionRequest(
        @NotEmpty String account,
        @NotEmpty String transactionType,
        @DecimalMin(value = "0.01", message = "O value da movimentacao deve ser maior que zero")
        BigDecimal value
) {}
