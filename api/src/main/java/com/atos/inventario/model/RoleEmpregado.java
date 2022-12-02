package com.atos.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ROLES_EMPREGADO")
public class RoleEmpregado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
