package com.atos.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.atosdto.FiltroPesquisaEmpregadoDTO;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.repositories.EmpregadoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmpregadoController {

	@Autowired
	EmpregadoRepository empregadoRepository;

	@GetMapping(value = "/empregado")
	public Empregado buscarEmpregado(@RequestParam String matricula, @RequestParam String senha) {

		Empregado empregado = empregadoRepository.findByMatriculaSenha(matricula, senha);

		return empregado;
	}

	@PostMapping(value = "/empregado")
	public List<Empregado> pesquisar(@RequestBody(required = false) FiltroPesquisaEmpregadoDTO filtro) {
		
		return null;
	}

}