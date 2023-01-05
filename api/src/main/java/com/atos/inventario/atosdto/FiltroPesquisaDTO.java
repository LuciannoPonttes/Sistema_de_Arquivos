package com.atos.inventario.atosdto;

import java.util.Date;

public class FiltroPesquisaDTO {

	private String tipoDocumento;
	private Long unidadeProdutora;
	private Long classificacaoDocumental;
	private Date DataLimite;
	private String Localizacao;

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getUnidadeProdutora() {
		return unidadeProdutora;
	}

	public void setUnidadeProdutora(Long unidadeProdutora) {
		this.unidadeProdutora = unidadeProdutora;
	}

	public Long getClassificacaoDocumental() {
		return classificacaoDocumental;
	}

	public void setClassificacaoDocumental(Long classificacaoDocumental) {
		this.classificacaoDocumental = classificacaoDocumental;
	}

	public Date getDataLimite() {
		return DataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		DataLimite = dataLimite;
	}

	public String getLocalizacao() {
		return Localizacao;
	}

	public void setLocalizacao(String localizacao) {
		Localizacao = localizacao;
	}

}
