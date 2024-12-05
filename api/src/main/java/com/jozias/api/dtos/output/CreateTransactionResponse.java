package com.jozias.api.dtos.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateTransactionResponse(
    LocalDateTime date,
    String account,
    String transactionType,
    BigDecimal value
)
    {}
