package com.jozias.api.documentation;

import com.jozias.api.dtos.input.CreateAccountRequest;
import com.jozias.api.dtos.output.CreateAccountResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Criar Conta")
public interface CreateContaDoc {

    @Operation(summary = "Criar Conta", description = "Cria uma nova account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Conta criada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateAccountResponse.class))),
            @ApiResponse(responseCode = "409", description = "Conta já cadastrada"),
            @ApiResponse(responseCode = "409", description = "Cpf já cadastrado")
    })
    ResponseEntity<CreateAccountResponse> create(CreateAccountRequest createAccountRequest);
}