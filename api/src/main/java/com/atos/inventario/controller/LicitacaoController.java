package com.atos.inventario.controller;

import java.util.Date;
import java.util.List;
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
//	public ResponseEntity<List<Licitacao>> listarLicitacao(@RequestBody Map<String, String> filtro) {

		// TODO organizar os filtros
		/* 
		 * Licitacao.documentoEncaminhamento 
		 * Licitacao.unidadeProdutora
		 * Licitacao.numeroCaixaEscritorioOrigem
		 * Licitacao.numeroCaixaArquivoCustodia
		 * Licitacao.classificacaoDocumental
		 * Licitacao.dataLimite
 		 * Licitacao.numeroProcessoLicitatorio
 		 * Licitacao.numeroPec
		 * Licitacao.objetoResumido
		 * Licitacao.localizacao
		 * 
		 * */
		
//		List<Licitacao> licitacoes = licitacaoRepository.findAll().stream()
//		.filter(l -> l.getDocumentoEncaminhamento().equals(filtro.get("documentoEncaminhamento"))
//				&& l.getUnidadeProdutora().getSigla().equals(filtro.get("unidadeProdutora"))
//				&& l.getNumeroCaixaEscritorioOrigem().equals(filtro.get("numeroCaixaEscritorioOrigem"))
//				&& l.getNumeroCaixaArquivoCustodia().equals(filtro.get("numeroCaixaArquivoCustodia"))
//				&& l.getClassificacaoDocumental().getCodigoClassificacaoDocumental() == Integer.parseInt(filtro.get("codigoClassificacaoDocumental"))
//				&& l.getDataLimite().equals(new Date(filtro.get("dataLimite")))
//				&& l.getNumeroProcessoLicitatorio().equals(filtro.get("numeroProcessoLicitatorio"))
//				&& l.getNumeroPec().equals(filtro.get("numeroPec"))
//				&& l.getObjetoResumido().equals(filtro.get("objetoResumido"))
//				&& l.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.get("idLocalizacao")))
//		.collect(Collectors.toList());
		
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
		if (licitacao != null) {
			return ResponseEntity.ok(licitacao);
		} else {
			return ResponseEntity.notFound().build();
		}
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
