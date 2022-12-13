package com.atos.inventario.services;

import java.util.ArrayList;
import java.util.List;
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
		
		List<IRowCount> listaContrato = new ArrayList<>();
		if (filtro.getPredio() == null) {
			listaContrato.addAll(contratoRepository.pesquisaAgrupadaEndereco(filtro.getUnidade()));
		} else {
			listaContrato.addAll(contratoRepository.pesquisaAgrupadaEnderecoPredio(filtro.getUnidade(), filtro.getPredio()));
		}
		
		RelatorioDocumentoUnidadeDTO resultado = new RelatorioDocumentoUnidadeDTO();
		resultado.setFiltro(filtro);
		for(IRowCount x : listaContrato) {
			resultado.getTotalQuantidade().put("CONTRATO;"+x.getEndereco(),  x.getTotal().toString());
		}
		return resultado;
	}

	@Override
	public RelatorioDocumentoUnidadeDTO gerarRelatorio2(FiltroRelatorioDocumentoUnidadeDTO filtro) {
		RelatorioDocumentoUnidadeDTO resultado = new RelatorioDocumentoUnidadeDTO();
		return resultado;
	}

}
