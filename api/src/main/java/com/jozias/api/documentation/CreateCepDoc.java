package com.jozias.api.documentation;

import com.jozias.api.dtos.input.CreateCepRequest;
import com.jozias.api.dtos.output.CepResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Criar CEP")
public interface CreateCepDoc {

    @Operation(summary = "Criar CEP", description = "Cria um novo CEP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CEP criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CepResponse.class))),
            @ApiResponse(responseCode = "409", description = "Cep ja cadastrado")
    })
    public ResponseEntity<CepResponse> create(CreateCepRequest createCepRequest);
}