package com.atos.inventario.repositories;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.inventario.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	Contrato findById(long id);
	
	@Query("SELECT count(c) as totais, c.localizacao.endereco||';'||c.localizacao.predio from Contrato c where c.localizacao.endereco like '%:endereco%' and c.localizacao.predio like '%:predio%' group by c.localizacao.endereco, c.localizacao.predio")
	Map<String,String> pesquisaAgrupada(String endereco,String predio);
}