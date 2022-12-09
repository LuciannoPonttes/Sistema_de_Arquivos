package com.atos.inventario.enums;

public enum DepartamentoEmpregadoEnum {
	GERENCIA (1,"GERE","GERENCIA"),
	COMPRAS (2,"COMP","COMPRAS"),
	VENDAS (3,"VEND","VENDAS"),
	RH (4,"RH","RECURSOS HUMANOS"),
	MARKETING (5,"MARK","MARKETING");
	
	private int idDepartamento;
	private String sigla;
	private String descricao;
	
	private DepartamentoEmpregadoEnum(int id, String sigla, String descricao) {
		this.idDepartamento = id;
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}


}
