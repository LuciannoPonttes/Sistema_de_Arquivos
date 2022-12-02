package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ARQUIVO_CONTRATO")
public class Contrato extends Documento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idArquivoContrato;
	
	private String documentoEncaminhamento;
	private String numeroCaixaEscritorioOrigem;
	private String numeroCaixaArquivoCustodia;
	private String numeroContrato;
	private String numeroPec;
	private String empresaContratada;
	private String objetoResumido;
	
	public long getIdArquivoContrato() {
		return idArquivoContrato;
	}
	public void setIdArquivoContrato(long idArquivoContrato) {
		this.idArquivoContrato = idArquivoContrato;
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
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public String getNumeroPec() {
		return numeroPec;
	}
	public void setNumeroPec(String numeroPec) {
		this.numeroPec = numeroPec;
	}
	public String getEmpresaContratada() {
		return empresaContratada;
	}
	public void setEmpresaContratada(String empresaContratada) {
		this.empresaContratada = empresaContratada;
	}
	public String getObjetoResumido() {
		return objetoResumido;
	}
	public void setObjetoResumido(String objetoResumido) {
		this.objetoResumido = objetoResumido;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
