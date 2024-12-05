package com.jozias.web.dto.input;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        String cep,

        String rua,

        Integer numero,

        @NotBlank(message = "Cidade é obrigatório")
        String cidade,

        @NotBlank(message = "Estado é obrigatório")
        String estado
) {
}
