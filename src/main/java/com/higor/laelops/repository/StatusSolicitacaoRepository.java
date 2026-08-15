package com.higor.laelops.repository;

import com.higor.laelops.model.SolicitacaoRemocao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusSolicitacaoRepository extends JpaRepository<SolicitacaoRemocao, Long> {
}
