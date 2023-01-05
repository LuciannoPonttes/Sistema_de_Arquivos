package com.atos.inventario.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.atosdto.ContratoDTO;
import com.atos.inventario.atosdto.FiltroPesquisaDTO;
import com.atos.inventario.enums.UnidadeProdutoraEnum;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Contrato;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.repositories.*;
import com.atos.inventario.services.LocalizacaoService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContratoController {

	@Autowired
	ContratoRepository contratoRepository;
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
		
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;
	
	@PostMapping("/contrato/listar")
	public ResponseEntity<List<Contrato>> listarContrato(@RequestBody(required=false) FiltroPesquisaDTO filtro) {
		
		// TODO organizar os filtros
		/* 
		 * Contrato.documentoEncaminhamento 
		 * Contrato.unidadeProdutora
		 * Contrato.classificacaoDocumental
		 * Contrato.dataLimite
		 * Contrato.numeroContrato
		 * Contrato.numeroPec
		 * Contrato.empresaContratada
		 * Contrato.objetoResumido
		 * Contrato.localizacao
		 * Empregado.departamento
		 * 
		 * */

		List<Contrato> contratos = contratoRepository.findAll().stream()
				.filter(filtro.getUnidadeProdutora() != null ? c -> c.getUnidadeProdutora().getCodigo().equals(filtro.getUnidadeProdutora()) : c -> true)
				.filter(filtro.getClassificacaoDocumental() != null ? c -> c.getClassificacaoDocumental().getCodigoClassificacaoDocumental().equals(filtro.getClassificacaoDocumental())  : c -> true)
				.filter(filtro.getDataLimite() != null ? c -> c.getDataLimite().equals(filtro.getDataLimite()) : c -> true)
				.filter(filtro.getLocalizacao() != null ? c -> c.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.getLocalizacao()) : c -> true)
				.collect(Collectors.toList());

		return ResponseEntity.ok(contratos);
	}

	@PostMapping("/contrato/cadastrar")
	public ResponseEntity<Contrato> cadastrarContrato(@RequestBody ContratoDTO contratoDto) {
		ModelMapper mapper = new ModelMapper();
		
		Contrato contrato = mapper.map(contratoDto, Contrato.class);
		
		UnidadeProdutoraEnum unidadeProdutora = UnidadeProdutoraEnum.getByCodigo(contratoDto.getUnidadeProdutoraId());
		contrato.setUnidadeProdutora(unidadeProdutora);
		
		Empregado empregado = empregadoRepository.findById(contratoDto.getEmpregadoId()).get();
		contrato.setEmpregado(empregado);
		
		ClassificacaoDocumental classificacaoDocumental = classificacaoDocumentalRepository.findById(contratoDto.getClassificacaoDocumentalId()).get();
		contrato.setClassificacaoDocumental(classificacaoDocumental);
		
		Localizacao localizacao = localizacaoService.validaLocalizacao(contratoDto.getLocalizacao());
		contrato.setLocalizacao(localizacao);
		
		Contrato contratoRetorno = contratoRepository.save(contrato);

		return ResponseEntity.ok(contratoRetorno);
	}

	@GetMapping(value = "/contrato/{id}")
	public ResponseEntity<Contrato> buscarContrato(@PathVariable long id) {

		Contrato contrato = contratoRepository.findById(id);
		if (contrato != null) {
			return ResponseEntity.ok(contrato);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/contrato/{id}")
	public ResponseEntity<Void> deletarContrato(@PathVariable long id) {

		Contrato contrato = contratoRepository.findById(id);
		if (contrato != null) {
			contratoRepository.delete(contrato);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/contrato/{id}")
	public ResponseEntity<Contrato> editarContrato(@PathVariable long id, @RequestBody ContratoDTO contratoDto) {
		ModelMapper mapper = new ModelMapper();
		Contrato contrato = contratoRepository.findById(id);
	    contrato = mapper.map(contratoDto, Contrato.class);
		Contrato contratoRetorno = contratoRepository.save(contrato);

		return ResponseEntity.ok(contratoRetorno);
	}

}
