package com.atos.inventario.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_EMPREGADO")
public class Empregado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpregado;
	
	private String matricula;
	private String nome;
	private String senha;
	private Date dataLogin;
	private String departamento;
	@ManyToMany
	@JoinTable(name = "TB_ROLES_EMPREGADO",
		joinColumns = @JoinColumn(name = "idEmpregado"),
		inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<RoleEmpregado> roles;

	
	public long getIdAEmpregado() {
		return idEmpregado;
	}
	public void setIdAEmpregado(long idEmpregado) {
		this.idEmpregado = idEmpregado;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<RoleEmpregado> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEmpregado> roles) {
		this.roles = roles;
	}
	public Date getDataLogin() {
		return dataLogin;
	}
	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}
