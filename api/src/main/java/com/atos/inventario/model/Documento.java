package com.atos.inventario.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_unidade_produtora", referencedColumnName = "idUnidadeProdutora")
	private UnidadeProdutora unidadeProdutora;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_classificaco_documental", referencedColumnName = "codigoClassificacaoDocumental")
	private ClassificacaoDocumental classificacaoDocumental;
	
	private Date dataLimite;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_empregado", referencedColumnName = "idEmpregado")
	private Empregado empregado;
	
	private Date dataCriacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_localizacao", referencedColumnName = "idLocalizacao")
	private Localizacao localizacao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
