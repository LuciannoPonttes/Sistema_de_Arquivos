package com.atos.inventario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atos.inventario.model.Licitacao;

public interface LicitacaoRepository extends JpaRepository<Licitacao, Long> {

	Licitacao findById(long id);

	@Query("SELECT count(c) as total, c.localizacao.endereco as endereco from Licitacao c group by c.localizacao.endereco")
	List<IRowCount> pesquisaAgrupadaEndereco(String endereco);
	
	@Query("SELECT count(c) as total, c.localizacao.endereco||';'||c.localizacao.predio as endereco from Licitacao c group by c.localizacao.endereco, c.localizacao.predio")
	List<IRowCount> pesquisaAgrupadaEnderecoPredio(String endereco,String predio);
}
