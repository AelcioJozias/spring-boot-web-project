package com.jozias.api.dtos.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateCepRequest(
        @NotNull(message = "O campo cep não pode ser nulo ou vazio")
        @Pattern(regexp = "^[0-9]{8}$", message = "O campo cep deve conter apenas números")
        @Size(min = 7, max = 7, message = "O campo account deve ter 7 caracteres")
        @Schema(description = "CEP do endereço", example = "12345678")
        String cep,

        @NotEmpty(message = "O campo road não pode ser nulo ou vazio")
        @Schema(description = "Nome da road", example = "Rua Exemplo")
        String rua,

        @NotEmpty(message = "O campo state não pode ser nulo")
        @Size(min = 2, message = "O campo account deve conter mais que 2 caracteres. Dica, cadastre o nome completo do state" )
        @Schema(description = "Nome do state", example = "São Paulo")
        String estado
) {
}
