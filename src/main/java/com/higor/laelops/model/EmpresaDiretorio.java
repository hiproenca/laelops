package com.higor.laelops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "empresa_diretorio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaDiretorio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 100)
    private String categoria;

    @Convert(converter = CanalConverter.class)
    @Column(nullable = false, length = 20)
    private Canal canal;

    @Column(name = "contato_ou_link", nullable = false, columnDefinition = "TEXT")
    private String contatoOuLink;

    @Column(length = 100)
    private String pais;

    @Column(columnDefinition = "TEXT")
    private String instrucoes;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private OffsetDateTime criadoEm;

    @PrePersist
    protected void prePersist() {
        if (criadoEm == null) {
            criadoEm = OffsetDateTime.now();
        }
    }
}