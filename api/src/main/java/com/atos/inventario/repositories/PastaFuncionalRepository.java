package com.atos.inventario.repositories;

import com.atos.inventario.model.PastaFuncional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PastaFuncionalRepository extends JpaRepository<PastaFuncional, Long> {

	PastaFuncional findById(long id);
	
	@Query("SELECT count(c) as total, c.localizacao.endereco as endereco from PastaFuncional c group by c.localizacao.endereco")
	List<IRowCount> pesquisaAgrupadaEndereco(String endereco);
	
	@Query("SELECT count(c) as total, c.localizacao.endereco||';'||c.localizacao.predio as endereco from PastaFuncional c group by c.localizacao.endereco, c.localizacao.predio")
	List<IRowCount> pesquisaAgrupadaEnderecoPredio(String endereco,String predio);
}