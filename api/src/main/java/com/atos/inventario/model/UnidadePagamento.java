package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_UNIDADE_PAGAMENTO")
public class UnidadePagamento implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUnidadePagamento;
	private String sigla;
    private String descricao;
	
	public Long getIdUnidadePagamento() {
		return idUnidadePagamento;
	}

	public void setIdUnidadePagamento(Long idUnidadePagamento) {
		this.idUnidadePagamento = idUnidadePagamento;
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
