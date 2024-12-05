package com.jozias.api.dtos.output;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Response DTO for account search")
public record SearchAccountResponse(
        @Schema(description = "Account number", example = "1234567")
        String conta,

        @Schema(description = "Date of the account information", example = "2023-10-01T12:00:00")
        LocalDateTime data,

        @Schema(description = "Account balance", example = "1000.00")
        BigDecimal saldo
) {

}
