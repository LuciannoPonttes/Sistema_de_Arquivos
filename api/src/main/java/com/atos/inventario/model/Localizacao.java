package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCALIZACAO")
public class Localizacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLocalizacao;
	
	private String endereco;
	private String predio;
	private String sala;
	private String bloco;
	private String posicao;
	private String numeroCaixa;
	
	public long getIdLocalizacao() {
		return idLocalizacao;
	}
	public void setIdLocalizacao(long idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getPredio() {
		return predio;
	}
	public void setPredio(String predio) {
		this.predio = predio;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNumeroCaixa() {
		return numeroCaixa;
	}
	public void setNumeroCaixa(String numeroCaixa) {
		this.numeroCaixa = numeroCaixa;
	}
	
	
}
