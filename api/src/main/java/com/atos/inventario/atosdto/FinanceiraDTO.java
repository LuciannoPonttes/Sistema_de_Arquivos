package com.atos.inventario.atosdto;

import java.io.Serializable;
import java.util.Date;

public class FinanceiraDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String documentoEncaminhamento;
	private String numeroCaixaEscritorioOrigem;
	private String numeroCaixaArquivoCustodia;
	private Date dataPagamento;
	private String unidadePagamento;

	private Long unidadeProdutoraId;
	private Long classificacaoDocumentalId;
	private Date dataLimite;
	private Long empregadoId;

	private LocalizacaoDTO localizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getUnidadePagamento() {
		return unidadePagamento;
	}

	public void setUnidadePagamento(String unidadePagamento) {
		this.unidadePagamento = unidadePagamento;
	}

	public Long getUnidadeProdutoraId() {
		return unidadeProdutoraId;
	}

	public void setUnidadeProdutoraId(Long unidadeProdutoraId) {
		this.unidadeProdutoraId = unidadeProdutoraId;
	}

	public Long getClassificacaoDocumentalId() {
		return classificacaoDocumentalId;
	}

	public void setClassificacaoDocumentalId(Long classificacaoDocumentalId) {
		this.classificacaoDocumentalId = classificacaoDocumentalId;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Long getEmpregadoId() {
		return empregadoId;
	}

	public void setEmpregadoId(Long empregadoId) {
		this.empregadoId = empregadoId;
	}

	public LocalizacaoDTO getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoDTO localizacao) {
		this.localizacao = localizacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
