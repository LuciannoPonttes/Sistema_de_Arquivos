package com.atos.inventario.atosdto;

import java.io.Serializable;

public class EmpregadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long idEmpregado;
	private String matricula;
	private String nome;
	private String email;
	private String departamento;

	public EmpregadoDTO(Long idEmpregado, String nome, String matricula, String email, String departamento) {
		this.idEmpregado = idEmpregado;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.departamento = departamento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Long getIdEmpregado() {
		return idEmpregado;
	}

	public void setIdEmpregado(Long idEmpregado) {
		this.idEmpregado = idEmpregado;
	}
}
