package com.atos.inventario.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.model.Contrato;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.repositories.ContratoRepository;
import com.atos.inventario.repositories.EmpregadoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmpregadoController {

	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@GetMapping(value = "/empregado" )
	public Empregado buscarEmpregado(@RequestParam String matricula, @RequestParam String senha) {
		
		Empregado empregado = empregadoRepository.findByMatriculaSenha(matricula, senha);
		
		return empregado;
	}

}	
