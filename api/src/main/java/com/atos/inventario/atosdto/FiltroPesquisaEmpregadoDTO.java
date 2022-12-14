package com.atos.inventario.atosdto;

public class FiltroPesquisaEmpregadoDTO {

	private String nome;
	private String matricula;
	private String email;
	private String unidadeDepartamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnidadeDepartamento() {
		return unidadeDepartamento;
	}

	public void setUnidadeDepartamento(String unidadeDepartamento) {
		this.unidadeDepartamento = unidadeDepartamento;
	}

}
