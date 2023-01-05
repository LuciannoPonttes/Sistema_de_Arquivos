package com.atos.inventario.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.inventario.model.Empregado;
import com.atos.inventario.repositories.EmpregadoRepository;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private EmpregadoRepository empregadoRepository;

	@Override
	public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {       
        Empregado empregado = empregadoRepository.findByMatricula(matricula).orElseThrow(() -> new UsernameNotFoundException("Empregado não Encontrado" + matricula));
        return empregado;
	}

}
