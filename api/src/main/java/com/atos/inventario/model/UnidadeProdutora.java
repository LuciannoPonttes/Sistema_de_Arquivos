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
	private long idUnidadeProdutora;
	private String sigla;

	public long getIdUnidadeProdutora() {
		return idUnidadeProdutora;
	}

	public void setIdUnidadeProdutora(long idUnidadeProdutora) {
		this.idUnidadeProdutora = idUnidadeProdutora;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
