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
import com.atos.inventario.atosdto.LicitacaoDTO;
import com.atos.inventario.enums.UnidadeProdutoraEnum;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Licitacao;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;
import com.atos.inventario.repositories.EmpregadoRepository;
import com.atos.inventario.repositories.LicitacaoRepository;
import com.atos.inventario.services.LocalizacaoService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LicitacaoController {

	@Autowired
	LicitacaoRepository licitacaoRepository;
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
	
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;

	@PostMapping("/licitacoes")
	public ResponseEntity<List<Licitacao>> listarLicitacao(@RequestBody(required=false) FiltroPesquisaDTO filtro) {

		// TODO organizar os filtros
		/* 
		 * Licitacao.documentoEncaminhamento 
		 * Licitacao.unidadeProdutora
		 * Licitacao.classificacaoDocumental
		 * Licitacao.dataLimite
 		 * Licitacao.numeroProcessoLicitatorio
 		 * Licitacao.numeroPec
		 * Licitacao.objetoResumido
		 * Licitacao.localizacao
		 * Empregado.departamento
		 * 
		 * */
		
		List<Licitacao> licitacoes = licitacaoRepository.findAll().stream()
				.filter(filtro.getUnidadeProdutora() != null ? l -> l.getUnidadeProdutora().getIdUnidadeProdutora().equals(filtro.getUnidadeProdutora()) : l -> true)
				.filter(filtro.getClassificacaoDocumental() != null ? l -> l.getClassificacaoDocumental().getCodigoClassificacaoDocumental().equals(filtro.getClassificacaoDocumental()) : l -> true)
				.filter(filtro.getDataLimite() != null ? l -> l.getDataLimite().equals(filtro.getDataLimite()) : l -> true)
				.filter(filtro.getLocalizacao() != null ? l -> l.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.getLocalizacao()) : l -> true)
				.collect(Collectors.toList());

		return ResponseEntity.ok(licitacoes);
	}

	@PostMapping("/cadastrarLicitacao")
	public ResponseEntity<Licitacao> cadastrarLicitacao(@RequestBody LicitacaoDTO licitacaoDto) {
		
		ModelMapper mapper = new ModelMapper();
		
		Licitacao licitacao = mapper.map(licitacaoDto, Licitacao.class);
		
		UnidadeProdutoraEnum unidadeProdutora = UnidadeProdutoraEnum.getByCodigo(licitacaoDto.getUnidadeProdutoraId());
		licitacao.setUnidadeProdutora(unidadeProdutora);
		
		Empregado empregado = empregadoRepository.findById(licitacaoDto.getEmpregadoId()).get();
		licitacao.setEmpregado(empregado);
		
		ClassificacaoDocumental classificacaoDocumental = classificacaoDocumentalRepository.findById(licitacaoDto.getClassificacaoDocumentalId()).get();
		licitacao.setClassificacaoDocumental(classificacaoDocumental);
		
		Localizacao localizacao = localizacaoService.validaLocalizacao(licitacaoDto.getLocalizacao());
		licitacao.setLocalizacao(localizacao);

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
