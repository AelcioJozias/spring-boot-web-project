package com.jozias.web.dto.output;

public record EnderecoResponse(String cep, String rua, Integer numero, String cidade, String estado) {
}
