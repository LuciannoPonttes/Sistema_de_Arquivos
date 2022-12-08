package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TB_ROLES_EMPREGADO")
public class RoleEmpregado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRoleEmpregado;
	
	private String nomeRole;

	public long getIdRoleEmpregado() {
		return idRoleEmpregado;
	}

	public void setIdRoleEmpregado(long idRoleEmpregado) {
		this.idRoleEmpregado = idRoleEmpregado;
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

}
