package com.higor.laelops.repository;

import com.higor.laelops.model.EmpresaDiretorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpresaDiretorioRepository extends JpaRepository<EmpresaDiretorio, UUID> {
}