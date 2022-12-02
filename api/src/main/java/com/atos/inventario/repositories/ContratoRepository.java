package com.atos.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.inventario.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	Contrato findById(long id);

}
