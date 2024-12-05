package com.jozias.api.dtos.output;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateAccountResponse(
        @Schema(description = "ID da account", example = "1")
        Integer id,

        @Schema(description = "CPF do titular da account", example = "12345678901")
        String cpf,

        @Schema(description = "Número da account", example = "1234567")
        String account
) {
}
