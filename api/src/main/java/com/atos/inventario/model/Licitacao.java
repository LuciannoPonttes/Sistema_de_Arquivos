package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LICITACAO")
public class Licitacao extends Documento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String documentoEncaminhamento;
	private String numeroCaixaEscritorioOrigem;
	private String numeroCaixaArquivoCustodia;
	private String numeroProcessoLicitatorio;
	private String numeroPec;
	private String objetoResumido;
	
	public String getNumeroProcessoLicitatorio() {
		return numeroProcessoLicitatorio;
	}

	public void setNumeroProcessoLicitatorio(String numeroProcessoLicitatorio) {
		this.numeroProcessoLicitatorio = numeroProcessoLicitatorio;
	}

	public String getObjetoResumido() {
		return objetoResumido;
	}

	public void setObjetoResumido(String objetoResumido) {
		this.objetoResumido = objetoResumido;
	}

	public String getNumeroPec() {
		return numeroPec;
	}

	public void setNumeroPec(String numeroPec) {
		this.numeroPec = numeroPec;
	}

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

}
