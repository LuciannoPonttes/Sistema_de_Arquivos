package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLASSIFICACAO_DOCUMENTAL")
public class ClassificacaoDocumental implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoClassificacaoDocumental;
	
	private String classificacaoDocumental;
	private String descricao;
	
	public int getCodigoClassificacaoDocumental() {
		return codigoClassificacaoDocumental;
	}
	public void setCodigoClassificacaoDocumental(int codigoClassificacaoDocumental) {
		this.codigoClassificacaoDocumental = codigoClassificacaoDocumental;
	}
	public String getClassificacaoDocumental() {
		return classificacaoDocumental;
	}
	public void setClassificacaoDocumental(String classificacaoDocumental) {
		this.classificacaoDocumental = classificacaoDocumental;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}