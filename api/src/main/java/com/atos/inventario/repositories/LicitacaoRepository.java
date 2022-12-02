package com.atos.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.inventario.model.Licitacao;

public interface LicitacaoRepository extends JpaRepository<Licitacao, Long> {

	Licitacao findById(long id);

}
