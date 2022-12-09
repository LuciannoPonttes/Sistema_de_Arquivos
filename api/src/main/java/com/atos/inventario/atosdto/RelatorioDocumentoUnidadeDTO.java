package com.atos.inventario.atosdto;

import java.util.Map;

public class RelatorioDocumentoUnidadeDTO {

	private Map<String, String> totalQuantidade;

	private Map<String, String> endereco;

	private Map<String, String> indiceDocumento;

	private FiltroRelatorioDocumentoUnidadeDTO filtro;

	public Map<String, String> getTotalQuantidade() {
		return totalQuantidade;
	}

	public void setTotalQuantidade(Map<String, String> totalQuantidade) {
		this.totalQuantidade = totalQuantidade;
	}

	public Map<String, String> getEndereco() {
		return endereco;
	}

	public void setEndereco(Map<String, String> endereco) {
		this.endereco = endereco;
	}

	public Map<String, String> getIndiceDocumento() {
		return indiceDocumento;
	}

	public void setIndiceDocumento(Map<String, String> indiceDocumento) {
		this.indiceDocumento = indiceDocumento;
	}

	public FiltroRelatorioDocumentoUnidadeDTO getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroRelatorioDocumentoUnidadeDTO filtro) {
		this.filtro = filtro;
	}

}
