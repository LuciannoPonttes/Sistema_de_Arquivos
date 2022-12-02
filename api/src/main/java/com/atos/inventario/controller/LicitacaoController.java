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
	public ResponseEntity<List<Licitacao>> listarLicitacao() {

		List<Licitacao> licitacoes = licitacaoRepository.findAll();

		return ResponseEntity.ok(licitacoes);
	}

	@PostMapping("/cadastrarLicitacao")
	public ResponseEntity<Licitacao> cadastrarLicitacao(@RequestBody Licitacao licitacao) {

		Licitacao licitacaoRetorno = licitacaoRepository.save(licitacao);

		return ResponseEntity.ok(licitacaoRetorno);
	}

	@GetMapping(value = "/licitacao/{id}")
	public ResponseEntity<Licitacao> buscarLicitacao(@PathVariable long id) {

		Licitacao licitacao = licitacaoRepository.findById(id);

		return ResponseEntity.ok(licitacao);
	}

	@DeleteMapping(value = "/licitacao/{id}")
	public ResponseEntity<Void> deletarLicitacao(@PathVariable long id) {

		Licitacao licitacao = licitacaoRepository.findById(id);
		licitacaoRepository.delete(licitacao);

		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/licitacao/{id}")
	public ResponseEntity<Licitacao> editarLicitacao(@RequestBody Licitacao licitacao) {

		Licitacao licitacaoRetorno = licitacaoRepository.save(licitacao);

		return ResponseEntity.ok(licitacaoRetorno);
	}

}
