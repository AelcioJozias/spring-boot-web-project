package com.jozias.api.dtos.output;

import io.swagger.v3.oas.annotations.media.Schema;

public record CepResponse(
        @Schema(description = "CEP do endereço", example = "12345678")
        String cep,

        @Schema(description = "Nome da road", example = "Rua Exemplo")
        String road,

        @Schema(description = "Nome do state", example = "São Paulo")
        String state
) {
}
