package com.atos.inventario.services;

import com.atos.inventario.atosdto.FiltroRelatorioDocumentoUnidadeDTO;
import com.atos.inventario.atosdto.RelatorioDocumentoUnidadeDTO;

public interface RelatorioService {
	
	public RelatorioDocumentoUnidadeDTO gerarRelatorio1(FiltroRelatorioDocumentoUnidadeDTO filtro);
	
	public RelatorioDocumentoUnidadeDTO gerarRelatorio2(FiltroRelatorioDocumentoUnidadeDTO filtro);
	 
	
}
