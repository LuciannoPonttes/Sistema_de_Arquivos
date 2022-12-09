package com.atos.inventario.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.inventario.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, UUID> {

	@Query("SELECT e FROM Empregado e WHERE e.nome=:nome and e.senha =:senha ")
    public Empregado findByNomeSenha(String nome, String senha);
	
}