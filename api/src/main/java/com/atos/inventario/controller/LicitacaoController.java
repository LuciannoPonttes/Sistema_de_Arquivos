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

import com.atos.inventario.model.Licitacao;
import com.atos.inventario.repositories.LicitacaoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LicitacaoController {

	@Autowired
	LicitacaoRepository licitacaoRepository;

	@GetMapping("/licitacoes")
	public List<Licitacao> listarLicitacao() {

		List<Licitacao> licitacoes = licitacaoRepository.findAll();
		return licitacoes;
	}

	@PostMapping("/cadastrarLicitacao")
	public void cadastrarLicitacao(@RequestBody Licitacao licitacao) {

		licitacaoRepository.save(licitacao);
	}

	@GetMapping(value = "/licitacao/{id}")
	public Licitacao buscarLicitacao(@PathVariable long id) {

		Licitacao licitacao = licitacaoRepository.findById(id);

		return licitacao;
	}

	@DeleteMapping(value = "/licitacaoDelete/{id}")
	public ResponseEntity<Void> deletarLicitacao(@PathVariable long id) {

		Licitacao licitacao = licitacaoRepository.findById(id);
		licitacaoRepository.delete(licitacao);

		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editarLicitacao")
	public void editarLicitacao(@RequestBody Licitacao licitacao) {

		licitacaoRepository.save(licitacao);
	}

}
