package com.atos.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.inventario.model.Financeira;

public interface FinanceiraRepository extends JpaRepository<Financeira, Long> {

	Financeira findById(long id);

}
