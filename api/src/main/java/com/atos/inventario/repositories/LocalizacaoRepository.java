package com.atos.inventario.repositories;

import com.atos.inventario.model.Localizacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
	
}