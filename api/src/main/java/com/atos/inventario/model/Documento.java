package com.atos.inventario.model;

import java.util.Date;

import javax.persistence.ManyToOne;

public abstract class Documento {
	
	@ManyToOne
	private UnidadeProdutora unidadeProdutora;
	@ManyToOne
	private ClassificacaoDocumental classificacaoDocumental;
	private Date dataLimite;
	@ManyToOne
	private Empregado empregado;
	private Date dataCriacao;
	@ManyToOne
	private Localizacao localizacao;
	
	public UnidadeProdutora getUnidadeProdutora() {
		return unidadeProdutora;
	}
	public void setUnidadeProdutora(UnidadeProdutora unidadeProdutora) {
		this.unidadeProdutora = unidadeProdutora;
	}
	public ClassificacaoDocumental getClassificacaoDocumental() {
		return classificacaoDocumental;
	}
	public void setClassificacaoDocumental(ClassificacaoDocumental classificacaoDocumental) {
		this.classificacaoDocumental = classificacaoDocumental;
	}
	public Date getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	
	
}
