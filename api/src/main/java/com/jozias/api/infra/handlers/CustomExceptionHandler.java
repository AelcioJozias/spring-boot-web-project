package com.jozias.api.infra.handlers;

import com.jozias.api.exception.EntityInUseException;
import com.jozias.api.exception.EntityNotFoundException;
import com.jozias.api.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

import static com.jozias.api.infra.handlers.ExceptionResponseBuilder.buildExceptionResponse;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityInUseException.class)
    public ResponseEntity<Map<String, Object>> handleEntityInUseException(final EntityInUseException ex, final WebRequest request) {
        Map<String, Object> body = buildExceptionResponse(ex, request, CONFLICT);
        return new ResponseEntity<>(body, CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(final EntityNotFoundException ex, final WebRequest request) {
        Map<String, Object> body = buildExceptionResponse(ex, request, NOT_FOUND);
        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessException(final BusinessException ex, final WebRequest request) {
        Map<String, Object> body = buildExceptionResponse(ex, request, BAD_REQUEST);
        return new ResponseEntity<>(body, BAD_REQUEST);
    }


}