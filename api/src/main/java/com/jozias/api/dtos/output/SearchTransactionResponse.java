package com.jozias.api.dtos.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SearchTransactionResponse(LocalDateTime date, BigDecimal value) {
}
