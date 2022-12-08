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

import com.atos.inventario.model.Financeira;
import com.atos.inventario.repositories.FinanceiraRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FinanceiraController {

	@Autowired
	FinanceiraRepository financeiraRepository;

	@GetMapping("/financeiras")
	public ResponseEntity<List<Financeira>> listarFinanceira() {
//	public ResponseEntity<List<Financeira>> listarFinanceira(@RequestBody Map<String, String> filtro) {
		
		// TODO organizar os filtros
		/* 
		 * Financeira.documentoEncaminhamento 
		 * Financeira.unidadeProdutora
		 * Financeira.numeroCaixaEscritorioOrigem
		 * Financeira.numeroCaixaArquivoCustodia
		 * Financeira.classificacaoDocumental
		 * Financeira.dataLimite
		 * Financeira.dataPagamento
		 * Financeira.unidadePagamento
		 * Financeira.localizacao
		 * 
		 * */

//		List<Financeira> financeiras = financeiraRepository.findAll().stream()
//				.filter(f -> f.getDocumentoEncaminhamento().equals(filtro.get("documentoEncaminhamento"))
//						&& f.getUnidadeProdutora().getSigla().equals(filtro.get("unidadeProdutora"))
//						&& f.getNumeroCaixaEscritorioOrigem().equals(filtro.get("numeroCaixaEscritorioOrigem"))
//						&& f.getNumeroCaixaArquivoCustodia().equals(filtro.get("numeroCaixaArquivoCustodia"))
//						&& f.getClassificacaoDocumental().getCodigoClassificacaoDocumental() == Integer.parseInt(filtro.get("codigoClassificacaoDocumental"))
//						&& f.getDataLimite().equals(new Date(filtro.get("dataLimite")))
//						&& f.getDataPagamento().equals(new Date(filtro.get("dataPagamento")))
//						&& f.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.get("idLocalizacao")))
//				.collect(Collectors.toList());

		List<Financeira> financeiras = financeiraRepository.findAll();

		return ResponseEntity.ok(financeiras);
	}

	@PostMapping("/cadastrarFinanceira")
	public ResponseEntity<Financeira> cadastrarFinanceira(@RequestBody Financeira financeira) {

		Financeira financeiraRetorno = financeiraRepository.save(financeira);

		return ResponseEntity.ok(financeiraRetorno);
	}

	@GetMapping(value = "/financeira/{id}")
	public ResponseEntity<Financeira> buscarFinanceira(@PathVariable long id) {

		Financeira financeira = financeiraRepository.findById(id);

		return ResponseEntity.ok(financeira);
	}

	@DeleteMapping(value = "/financeira/{id}")
	public ResponseEntity<Void> deletarFinanceira(@PathVariable long id) {

		Financeira financeira = financeiraRepository.findById(id);
		financeiraRepository.delete(financeira);

		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/financeira/{id}")
	public ResponseEntity<Financeira> editarFinanceira(@RequestBody Financeira financeira) {

		Financeira financeiraRetorno = financeiraRepository.save(financeira);

		return ResponseEntity.ok(financeiraRetorno);
	}

}
