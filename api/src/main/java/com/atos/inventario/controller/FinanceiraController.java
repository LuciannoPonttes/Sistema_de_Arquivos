package com.atos.inventario.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import com.atos.inventario.atosdto.FiltroPesquisaDTO;
import com.atos.inventario.atosdto.FinanceiraDTO;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Financeira;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.model.UnidadeProdutora;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;
import com.atos.inventario.repositories.EmpregadoRepository;
import com.atos.inventario.repositories.FinanceiraRepository;
import com.atos.inventario.repositories.UnidadeProdutoraRepository;
import com.atos.inventario.services.LocalizacaoService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FinanceiraController {

	@Autowired
	FinanceiraRepository financeiraRepository;
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
	
	@Autowired
	UnidadeProdutoraRepository unidadeProdutoraRepository;
	
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;

	@PostMapping("/financeiras")
	public ResponseEntity<List<Financeira>> listarFinanceira(@RequestBody(required=false) FiltroPesquisaDTO filtro) {
		
		// TODO organizar os filtros
		/* 
		 * Financeira.documentoEncaminhamento 
		 * Financeira.unidadeProdutora
		 * Financeira.classificacaoDocumental
		 * Financeira.dataLimite
		 * Financeira.dataPagamento
		 * Financeira.unidadePagamento
		 * Financeira.localizacao
		 * Empregado.departamento
		 * 
		 * */

		List<Financeira> financeiras = financeiraRepository.findAll().stream()
				.filter(filtro.getUnidadeProdutora() != null ? f -> f.getUnidadeProdutora().getIdUnidadeProdutora().equals(filtro.getUnidadeProdutora()) : f -> true)
				.filter(filtro.getClassificacaoDocumental() != null ? f -> f.getClassificacaoDocumental().getCodigoClassificacaoDocumental().equals(filtro.getClassificacaoDocumental()) : c -> true)
				.filter(filtro.getDataLimite() != null ? f -> f.getDataLimite().equals(filtro.getDataLimite()) : c -> true)
				.filter(filtro.getLocalizacao() != null ? f -> f.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.getLocalizacao()) : c -> true)
				.collect(Collectors.toList());

		return ResponseEntity.ok(financeiras);
	}

	@PostMapping("/cadastrarFinanceira")
	public ResponseEntity<Financeira> cadastrarFinanceira(@RequestBody FinanceiraDTO financeiraDto) {
		ModelMapper mapper = new ModelMapper();
		
		Financeira financeira = mapper.map(financeiraDto, Financeira.class);
		
		UnidadeProdutora unidadeProdutora = unidadeProdutoraRepository.findById(financeiraDto.getUnidadeProdutoraId()).get();
		financeira.setUnidadeProdutora(unidadeProdutora);
		
		Empregado empregado = empregadoRepository.findById(financeiraDto.getEmpregadoId()).get();
		financeira.setEmpregado(empregado);
		
		ClassificacaoDocumental classificacaoDocumental = classificacaoDocumentalRepository.findById(financeiraDto.getClassificacaoDocumentalId()).get();
		financeira.setClassificacaoDocumental(classificacaoDocumental);
		
		Localizacao localizacao = localizacaoService.validaLocalizacao(financeiraDto.getLocalizacao());
		financeira.setLocalizacao(localizacao);
		
		Financeira financeiraRetorno = financeiraRepository.save(financeira);

		return ResponseEntity.ok(financeiraRetorno);
	}

	@GetMapping(value = "/financeira/{id}")
	public ResponseEntity<Financeira> buscarFinanceira(@PathVariable long id) {

		Financeira financeira = financeiraRepository.findById(id);
		if (financeira != null) {
			return ResponseEntity.ok(financeira);
		} else {
			return ResponseEntity.notFound().build();
		}
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
