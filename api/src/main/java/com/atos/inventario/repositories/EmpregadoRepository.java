package com.atos.inventario.repositories;

import com.atos.inventario.model.Empregado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

}