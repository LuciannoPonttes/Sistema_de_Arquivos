package com.atos.inventario.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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

	final EmpregadoRepository empregadoRepository;
	
	public UserDetailServiceImpl(EmpregadoRepository empregadoRepository) {
		this.empregadoRepository = empregadoRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
		final List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        final UserDetails principal = new User(matricula, "senha", grantedAuths);
        return principal;
	}

}