package com.atos.inventario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.atos.inventario.enums.DepartamentoEmpregadoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_EMPREGADO")
public class Empregado implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpregado;
	
	@Column(nullable = false, unique = true)
	private String matricula;
	private String nome;
	@Column(nullable = false)
	private String senha;
	private String email;
	private Date dataLogin;
	private boolean ativo = true;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false, unique = true)
	private DepartamentoEmpregadoEnum departamento;
  
	@ManyToMany
	@JoinTable(name = "TB_ROLES_EMPREGADO",
		joinColumns = @JoinColumn(name = "idEmpregado"),
		inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<RoleEmpregado> roles;

	
	public Long getIdEmpregado() {
		return idEmpregado;
	}
	public void setIdEmpregado(long idEmpregado) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
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
	public int getDepartamentoId() {
		return departamento.getIdDepartamento();
	}
	@JsonIgnore
	public void setDepartamento(DepartamentoEmpregadoEnum departamento) {
		this.departamento = departamento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public String getDepartamentoDesc() {
		return departamento.getDescricao();
	}
	
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleEmpregado> rolesEmpregado = new ArrayList<RoleEmpregado>();
		rolesEmpregado.add(new RoleEmpregado());
		return rolesEmpregado;
	}
	@Override
	@JsonIgnore
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.matricula;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
