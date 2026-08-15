package com.higor.laelops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "verificacao_vazamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificacaoVazamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "email_consultado", nullable = false, length = 255)
    private String emailConsultado;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "resultado_json", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> resultadoJson;

    @Column(name = "verificado_em", nullable = false, updatable = false)
    private OffsetDateTime verificadoEm;

    @PrePersist
    protected void prePersist() {
        if (verificadoEm == null) {
            verificadoEm = OffsetDateTime.now();
        }
    }
}