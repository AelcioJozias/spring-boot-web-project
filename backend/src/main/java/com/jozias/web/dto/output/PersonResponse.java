package com.jozias.web.dto.output;

import java.util.Date;

public record PersonResponse(
        String nome,
        String cpf,
        Date nascimento,
        AddressResponse endereco
) {
}
