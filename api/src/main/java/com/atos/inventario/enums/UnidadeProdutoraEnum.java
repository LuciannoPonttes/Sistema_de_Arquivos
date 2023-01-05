package com.atos.inventario.enums;

public enum UnidadeProdutoraEnum {
	
	SEDE ("SEDE","SEDE"),
	BSBA ("BSBA","Aeroporto de Brasilia"),
	CONG ("CONG","Aeroporto de Congonhas"),
	MANU ("MANU","Aeroporto de Manaus");
	
	private String codigo;
	private String unidadeProdutora;
	
	private UnidadeProdutoraEnum(String codigo, String unidadeProdutora) {
		this.codigo = codigo;
		this.unidadeProdutora = unidadeProdutora;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getUnidadeProdutora() {
		return unidadeProdutora;
	}

	public static UnidadeProdutoraEnum getByCodigo(String codigo) {
		for (UnidadeProdutoraEnum item : values()) {
            if (item.getCodigo().equals(codigo)) {
				return item;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return this.unidadeProdutora;
	}
}
