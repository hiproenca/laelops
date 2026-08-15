package com.higor.laelops.repository;

import com.higor.laelops.model.VerificacaoVazamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VerificacaoVazamentoRepository extends JpaRepository<VerificacaoVazamento, UUID> {
}