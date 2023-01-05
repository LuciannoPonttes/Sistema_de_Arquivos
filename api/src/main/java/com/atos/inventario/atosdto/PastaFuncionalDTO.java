package com.atos.inventario.atosdto;

import java.io.Serializable;
import java.util.Date;

public class PastaFuncionalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String documentoEncaminhamento;
	private String numeroCaixaEscritorioOrigem;
	private String numeroCaixaArquivoCustodia;

	private String unidadeProdutoraId;
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

	public String getUnidadeProdutoraId() {
		return unidadeProdutoraId;
	}

	public void setUnidadeProdutoraId(String unidadeProdutoraId) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocalizacaoDTO getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoDTO localizacao) {
		this.localizacao = localizacao;
	}

}
