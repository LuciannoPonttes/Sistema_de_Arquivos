package com.atos.inventario.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.model.Contrato;
import com.atos.inventario.repositories.ContratoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContratoController {

	@Autowired
	ContratoRepository contratoRepository;

	@GetMapping("/contratos")
	public List<Contrato> listarContrato() {

		List<Contrato> contratos = contratoRepository.findAll();
		return contratos;
	}

	@PostMapping("/cadastrarContrato")
	public void cadastrarContrato(@RequestBody Contrato contrato) {

		contratoRepository.save(contrato);
	}

	@GetMapping(value = "/contrato/{id}")
	public Contrato buscarContrato(@PathVariable long id) {

		Contrato contrato = contratoRepository.findById(id);

		return contrato;
	}

	@DeleteMapping(value = "/contratoDelete/{id}")
	public ResponseEntity<Void> deletarContrato(@PathVariable long id) {

		Contrato contrato = contratoRepository.findById(id);
		contratoRepository.delete(contrato);

		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editarContrato")
	public void editarContrato(@RequestBody Contrato contrato) {

		contratoRepository.save(contrato);
	}

}
