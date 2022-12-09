package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_UNIDADE_PRODUTORA")
public class UnidadeProdutora implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUnidadeProdutora;
	private String sigla;
	private String descricao;

	public Long getIdUnidadeProdutora() {
		return idUnidadeProdutora;
	}

	public void setIdUnidadeProdutora(Long idUnidadeProdutora) {
		this.idUnidadeProdutora = idUnidadeProdutora;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
