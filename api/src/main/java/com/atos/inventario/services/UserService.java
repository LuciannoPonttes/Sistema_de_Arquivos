package com.atos.inventario.services;

import java.util.Optional;

import com.atos.inventario.model.Empregado;

public interface UserService {

	public Optional<Empregado> getUserWithAuthorities();

}
