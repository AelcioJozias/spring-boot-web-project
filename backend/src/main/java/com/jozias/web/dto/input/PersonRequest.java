package com.jozias.web.dto.input;

import com.jozias.web.validator.Name;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record PersonRequest(
        @Name(message = "Nome deve ter mais de um nome e cada nome deve começar com letra maiúscula")
        String nome,

//        @CPF(message = "CPF deve ser válido")
        @Pattern(regexp = "[0-9]+", message = "O campo conta deve conter apenas números")
        String cpf,

        Date nascimento,

        @NotNull(message = "O objeto endereco não pode ser nulo")
        AddressRequest endereco
) {
}
