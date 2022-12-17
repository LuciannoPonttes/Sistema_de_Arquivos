package com.atos.inventario.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.inventario.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	
	@Query("SELECT e FROM Empregado e WHERE e.matricula=:matricula and e.senha =:senha ")
	public Optional<Empregado> findByMatriculaSenha(String matricula, String senha);
	
	public Optional<Empregado> findByMatricula(String matricula);

	@Query("SELECT e FROM Empregado e WHERE e.ativo = true ")
	public List<Empregado> findByAtivoTrue();
}