package com.jozias.api.infra.handlers;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@UtilityClass
public class ExceptionResponseBuilder {

    public static Map<String, Object> buildExceptionResponse(final Exception ex, final WebRequest request, final HttpStatus httpStatus) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", httpStatus.value());
        body.put("error", httpStatus.getReasonPhrase());
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));
        return body;
    }
}
