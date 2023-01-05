package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_OUTRODOCUMENTO")
public class OutroDocumento extends Documento implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String documentoEncaminhamento;
	private String numeroCaixaEscritorioOrigem;
	private String numeroCaixaArquivoCustodia;
	private String objetoResumido;
	
	public String getDocumentoEncaminhamento() {
		return documentoEncaminhamento;
	}

	public void setDocumentoEncaminhamento(String documentoEncaminhamento) {
		this.documentoEncaminhamento = documentoEncaminhamento;
	}

	public String getNumeroCaixaEscritorioOrigem() {
		return numeroCaixaEscritorioOrigem;
	}

	public void setNumeroCaixaEscritorioOrigem(String numeroCaixaEscritorioOrigem) {
		this.numeroCaixaEscritorioOrigem = numeroCaixaEscritorioOrigem;
	}

	public String getNumeroCaixaArquivoCustodia() {
		return numeroCaixaArquivoCustodia;
	}

	public void setNumeroCaixaArquivoCustodia(String numeroCaixaArquivoCustodia) {
		this.numeroCaixaArquivoCustodia = numeroCaixaArquivoCustodia;
	}

	public String getObjetoResumido() {
		return objetoResumido;
	}

	public void setObjetoResumido(String objetoResumido) {
		this.objetoResumido = objetoResumido;
	}

}
