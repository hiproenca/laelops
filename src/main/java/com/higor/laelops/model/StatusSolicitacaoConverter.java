package com.higor.laelops.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class StatusSolicitacaoConverter implements AttributeConverter<StatusSolicitacao, String> {
    @Override
    public String convertToDatabaseColumn(StatusSolicitacao status) {
        return status == null ? null : status.name().toLowerCase();
    }
    @Override
    public StatusSolicitacao convertToEntityAttribute(String valorNoBanco) {
        return valorNoBanco == null ? null : StatusSolicitacao.valueOf(valorNoBanco.toUpperCase());
    }
}
