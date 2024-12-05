package com.jozias.api.dtos.input;

import com.jozias.api.validator.CPF;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateAccountRequest(
        @CPF(message = "CPF deve ser válido")
        @Pattern(regexp = "[0-9]+", message = "O campo account deve conter apenas números")
        @Schema(description = "CPF do titular da account", example = "12345678901")
        String cpf,

        @NotEmpty(message = "O campo account não pode ser nulo")
        @Size(min = 7, max = 7, message = "O campo account deve conter 7 caracteres")
        @Pattern(regexp = "[0-9]+", message = "O campo account deve conter apenas números")
        @Schema(description = "Número da account", example = "1234567")
        String account
) {
}
