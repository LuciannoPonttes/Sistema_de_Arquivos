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
	private Long codigoClassificacaoDocumental;
	
	private String descricao;
	
	public Long getCodigoClassificacaoDocumental() {
		return codigoClassificacaoDocumental;
	}
	public void setCodigoClassificacaoDocumental(Long codigoClassificacaoDocumental) {
		this.codigoClassificacaoDocumental = codigoClassificacaoDocumental;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
