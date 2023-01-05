package com.atos.inventario.atosdto;

import java.io.Serializable;

public class LoginRequestDTO implements Serializable{
	
	private static final long serialVersionUID = -3884998450525932556L;
	
	private String matricula;
	private String senha;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	
	

}
