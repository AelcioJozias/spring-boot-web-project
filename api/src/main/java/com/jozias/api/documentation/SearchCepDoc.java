package com.jozias.api.documentation;

import com.jozias.api.dtos.output.CepResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Pesquisar CEP")
public interface SearchCepDoc {

    @Operation(summary = "Pesquisar CEP", description = "Retorna informações sobre o CEP pesquisado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CEP encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CepResponse.class))),
            @ApiResponse(responseCode = "404", description = "CEP não encontrado")
    })
    ResponseEntity<CepResponse> search(@Parameter(description = "ID do cep", example = "88110300") @PathVariable String cep);
}