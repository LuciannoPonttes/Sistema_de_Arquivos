package com.atos.inventario.atosdto;

import java.io.Serializable;

public class FiltroRelatorioDocumentoUnidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String unidade;

	private String predio;

	private String dataRelatorio;

	
	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public String getDataRelatorio() {
		return dataRelatorio;
	}

	public void setDataRelatorio(String dataRelatorio) {
		this.dataRelatorio = dataRelatorio;
	}

}
