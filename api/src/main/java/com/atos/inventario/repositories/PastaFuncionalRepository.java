package com.atos.inventario.repositories;

import com.atos.inventario.model.PastaFuncional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PastaFuncionalRepository extends JpaRepository<PastaFuncional, Long> {

	PastaFuncional findById(long id);
}