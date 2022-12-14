package com.atos.inventario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.inventario.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

	@Query("SELECT e FROM Empregado e WHERE e.matricula=:matricula and e.senha =:senha ")
    Optional<Empregado> findByMatriculaSenha(String matricula, String senha);
	
	@Query("SELECT e FROM Empregado e WHERE e.matricula=:matricula and e.senha =:senha ")
	public Empregado findByMatriculaSenha2(String matricula, String senha);
	
	public Empregado findByMatricula(String matricula);
}