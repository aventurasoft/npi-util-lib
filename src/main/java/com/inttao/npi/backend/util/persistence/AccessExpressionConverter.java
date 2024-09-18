package com.inttao.npi.backend.util.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inttao.npi.backend.util.security.AccessExpression;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Converter
@Log4j2
public class AccessExpressionConverter implements AttributeConverter<AccessExpression, String> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(AccessExpression accessExpression) {
        if (accessExpression==null) return null;
        String accessExpressionJson = null;
        try {
            accessExpressionJson = objectMapper.writeValueAsString(accessExpression);
        } catch (final JsonProcessingException e) {
            log.error("JSON writing error", e);
        }
        return accessExpressionJson;
    }

    @Override
    public AccessExpression convertToEntityAttribute(String accessExpressionJson) {

        AccessExpression accessExpression = new AccessExpression();
        if (accessExpressionJson==null) return accessExpression;
        try {
            accessExpression = objectMapper.readValue(accessExpressionJson, AccessExpression.class);
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        }
        return accessExpression;
    }
}
