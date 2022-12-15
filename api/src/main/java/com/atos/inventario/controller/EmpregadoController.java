package com.atos.inventario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.model.Empregado;
import com.atos.inventario.repositories.EmpregadoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmpregadoController {

	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@GetMapping(value = "/empregado" )
	public Optional<Empregado> buscarEmpregado(@RequestParam String matricula, @RequestParam String senha) {
		
		Optional<Empregado> empregado = empregadoRepository.findByMatriculaSenha(matricula, senha);
		
		return empregado;
	}

}	
