package com.atos.inventario.repositories;

import com.atos.inventario.model.Localizacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
	
	@Query("SELECT count(l) as total, l.endereco as endereco from Localizacao l group by l.endereco")
	List<IRowCount> pesquisaAgrupadaEndereco(String endereco);
	
	@Query("SELECT count(l) as total, l.endereco||';'||l.predio as endereco from Localizacao l group by l.endereco, l.predio")
	List<IRowCount> pesquisaAgrupadaEnderecoPredio(String endereco,String predio);
	
}