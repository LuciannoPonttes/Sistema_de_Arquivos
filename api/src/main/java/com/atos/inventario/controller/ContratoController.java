package com.atos.inventario.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
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

import com.atos.inventario.atosdto.ContratoDTO;
import com.atos.inventario.atosdto.FiltroPesquisaDTO;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Contrato;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.model.UnidadeProdutora;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;
import com.atos.inventario.repositories.ContratoRepository;
import com.atos.inventario.repositories.UnidadeProdutoraRepository;
import com.atos.inventario.services.LocalizacaoService;
import com.atos.inventario.repositories.EmpregadoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContratoController {

	@Autowired
	ContratoRepository contratoRepository;
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
	
	@Autowired
	UnidadeProdutoraRepository unidadeProdutoraRepository;
	
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;
	
	@GetMapping("/contratos")
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

//		List<Contrato> contratos = contratoRepository.findAll().stream()
//				.filter(c -> c.getDocumentoEncaminhamento().equals(filtro.get("documentoEncaminhamento"))
//						&& c.getUnidadeProdutora().getSigla().equals(filtro.get("unidadeProdutora"))
//						&& c.getClassificacaoDocumental().getCodigoClassificacaoDocumental() == Integer
//								.parseInt(filtro.get("codigoClassificacaoDocumental"))
//						&& c.getDataLimite().equals(new Date(filtro.get("dataLimite")))
//						&& c.getNumeroContrato().equals(filtro.get("numeroContrato"))
//						&& c.getNumeroPec().equals(filtro.get("numeroPec"))
//						&& c.getEmpresaContratada().equals(filtro.get("empresaContratada"))
//						&& c.getObjetoResumido().equals(filtro.get("objetoResumido"))
//						&& c.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.get("idLocalizacao")))
//				.collect(Collectors.toList());

		List<Contrato> contratos = contratoRepository.findAll();
		
		return ResponseEntity.ok(contratos);
	}

	@PostMapping("/cadastrarContrato")
	public ResponseEntity<Contrato> cadastrarContrato(@RequestBody ContratoDTO contratoDto) {
		ModelMapper mapper = new ModelMapper();
		
		Contrato contrato = mapper.map(contratoDto, Contrato.class);
		
		UnidadeProdutora unidadeProdutora = unidadeProdutoraRepository.findById(contratoDto.getUnidadeProdutoraId()).get();
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
		contratoRepository.delete(contrato);

		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/contrato/{id}")
	public ResponseEntity<Contrato> editarContrato(@RequestBody Contrato contrato) {

		Contrato contratoRetorno = contratoRepository.save(contrato);

		return ResponseEntity.ok(contratoRetorno);
	}

}
