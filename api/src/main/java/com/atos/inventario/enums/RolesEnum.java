package com.atos.inventario.enums;

public enum RolesEnum {
	ADMIN ("ADMIN",1),
	USER ("USER",2);
	
	private String rol;
	private Integer rolId;
	
	private RolesEnum(String rol, Integer rolId) {
		this.rol = rol;
		this.rolId = rolId;
	}

	public String getRol() {
		return rol;
	}

	public Integer getRolId() {
		return rolId;
	}

	
}
