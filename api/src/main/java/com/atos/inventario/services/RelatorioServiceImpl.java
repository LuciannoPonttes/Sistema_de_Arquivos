package com.atos.inventario.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.inventario.atosdto.*;
import com.atos.inventario.model.*;
import com.atos.inventario.repositories.*;

@Service
public class RelatorioServiceImpl implements RelatorioService{

	@Autowired
	ContratoRepository contratoRepository;
	
	@Autowired
	LicitacaoRepository licitacaoRepository;
	
	@Autowired
	FinanceiraRepository financeiraRepository;
	
	@Autowired
	LocalizacaoRepository localizacaoRepository;
	
	@Override
	public RelatorioDocumentoUnidadeDTO gerarRelatorio1(FiltroRelatorioDocumentoUnidadeDTO filtro) {
		// opcao 1 lista com filtros e contar
		Long totalLicitacao = licitacaoRepository.findAll()
							.stream()
							.filter(c -> c.getLocalizacao().getEndereco().contains(filtro.getUnidade()))
							.filter(c -> c.getLocalizacao().getPredio().contains(filtro.getPredio()))
							.count();
		
		Long totalFinanceira = financeiraRepository.findAll()
				.stream()
				.filter(c -> c.getLocalizacao().getEndereco().contains(filtro.getUnidade()))
				.filter(c -> c.getLocalizacao().getPredio().contains(filtro.getPredio()))
				.count();

		// opcao 2 lista com query no repositorio
		Map<String,String> listaContrato = contratoRepository.pesquisaAgrupada(filtro.getUnidade(), filtro.getPredio());
		
		
		RelatorioDocumentoUnidadeDTO resultado = new RelatorioDocumentoUnidadeDTO();
		resultado.setFiltro(filtro);
		resultado.getTotalQuantidade().put("F001", totalLicitacao.toString());
		resultado.getTotalQuantidade().put("F002", totalFinanceira.toString());
		return resultado;
	}

	@Override
	public RelatorioDocumentoUnidadeDTO gerarRelatorio2(FiltroRelatorioDocumentoUnidadeDTO filtro) {
		RelatorioDocumentoUnidadeDTO resultado = new RelatorioDocumentoUnidadeDTO();
		return resultado;
	}

}
