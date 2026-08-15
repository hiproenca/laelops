package com.higor.laelops.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.OffsetDateTime;

import java.util.UUID;

@Entity
@Table(name = "solicitacao_remocao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SolicitacaoRemocao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private EmpresaDiretorio empresa;

    @Convert(converter = CanalConverter.class)
    @Column(nullable = false, length = 20)
    private Canal canalUsado;

    @Convert(converter = StatusSolicitacaoConverter.class)
    @Column(nullable = false, length = 20)
    private StatusSolicitacao status;

    private boolean consentimentoConfirmado;
    private OffsetDateTime dataEnvio;
    private String observacoes;
    //@Column(name = "criado_em", nullable = false, updatable = false)
    private OffsetDateTime criadoEm;
    @PrePersist
    protected void prePersist() {
        if (criadoEm == null) {
            criadoEm = OffsetDateTime.now();
        }
        if (status == null) {
            status = StatusSolicitacao.PENDENTE;
        }
    }


}
