package com.inttao.npi.backend.util.exceptions.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inttao.npi.backend.util.exceptions.ResourceNotFoundException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Clase ayuda para decodificar mensajes de excepción.
 */
public class ExceptionMessageDecoderHelper {
    public static ExceptionMessage decode(feign.Response response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body().asInputStream(), ExceptionMessage.class);
        } catch (IOException e) {
            throw new RuntimeException("Generic exception: " + response.reason(), e);
        }
    }
    public static ExceptionMessage decode(InputStream inputStream) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(inputStream, ExceptionMessage.class);
        } catch (IOException e) {
            throw new RuntimeException("Generic exception: " + e.getMessage(), e);
        }
    }

    public static ExceptionMessage decode(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, ExceptionMessage.class);
        } catch (IOException e) {
            throw new RuntimeException("Generic exception: " + e.getMessage(), e);
        }
    }

    /**
     * Procesa un mensaje de excepción y lo convierte en una excepción.
     * @param exceptionMessage Mensaje de excepción.
     * @return Excepción.
     */
    public static Exception processExceptionMessage(ExceptionMessage exceptionMessage) {
        if (exceptionMessage.getStatus() == 404) {
            return new ResourceNotFoundException(exceptionMessage.getMessage());
        } else
            return new RuntimeException("Error: " + exceptionMessage.getMessage());
    }
}
