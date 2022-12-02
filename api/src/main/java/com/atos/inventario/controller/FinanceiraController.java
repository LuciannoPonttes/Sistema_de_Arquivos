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

import com.atos.inventario.model.Financeira;
import com.atos.inventario.repositories.FinanceiraRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FinanceiraController {

	@Autowired
	FinanceiraRepository financeiraRepository;

	@GetMapping("/financeiras")
	public List<Financeira> listarFinanceira() {

		List<Financeira> financeiras = financeiraRepository.findAll();
		return financeiras;
	}

	@PostMapping("/cadastrarFinanceira")
	public void cadastrarFinanceira(@RequestBody Financeira financeira) {

		financeiraRepository.save(financeira);
	}

	@GetMapping(value = "/financeira/{id}")
	public Financeira buscarFinanceira(@PathVariable long id) {

		Financeira financeira = financeiraRepository.findById(id);

		return financeira;
	}

	@DeleteMapping(value = "/financeiraDelete/{id}")
	public ResponseEntity<Void> deletarFinanceira(@PathVariable long id) {

		Financeira financeira = financeiraRepository.findById(id);
		financeiraRepository.delete(financeira);

		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editarFinanceira")
	public void editarFinanceira(@RequestBody Financeira financeira) {

		financeiraRepository.save(financeira);
	}

}
