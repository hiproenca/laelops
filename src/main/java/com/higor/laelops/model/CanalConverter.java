package com.higor.laelops.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CanalConverter implements AttributeConverter<Canal, String> {

    @Override
    public String convertToDatabaseColumn(Canal canal) {
        return canal == null ? null : canal.name().toLowerCase();
    }

    @Override
    public Canal convertToEntityAttribute(String valorNoBanco) {
        return valorNoBanco == null ? null : Canal.valueOf(valorNoBanco.toUpperCase());
    }
}