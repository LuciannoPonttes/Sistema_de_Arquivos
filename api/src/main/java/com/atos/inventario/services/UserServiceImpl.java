package com.atos.inventario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.inventario.model.Empregado;
import com.atos.inventario.repositories.EmpregadoRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private EmpregadoRepository empregadoRepository;


    @Transactional(readOnly = true)
    public Optional<Empregado> getUserWithAuthorities() {
    	Optional<String> p = getCurrentUsername();
    	if (p.isPresent()) {
    		System.out.println("p:" + p.get());
    		return empregadoRepository.findByMatricula(p.get()); 
    	} else { 
    		return null;
    	}
    }

    private Optional<String> getCurrentUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
        	System.out.println("auth null");
            return Optional.empty();
        }

        String username = null;
        if (authentication.getPrincipal() instanceof Empregado) {
        	System.out.println("auth empregado");
        	Empregado springSecurityUser = (Empregado) authentication.getPrincipal();
            username = springSecurityUser.getMatricula();
        } else if (authentication.getPrincipal() instanceof String) {
        	System.out.println("auth string");
            username = (String) authentication.getPrincipal();
        }

         return Optional.ofNullable(username);
     }
}