package com.atos.inventario.atosdto;

import java.io.Serializable;

public class LoginResponseDTO implements Serializable{
	
	private static final long serialVersionUID = -3884998450525932556L;
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
