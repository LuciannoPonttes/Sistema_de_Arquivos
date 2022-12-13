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

import com.atos.inventario.atosdto.LicitacaoDTO;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Licitacao;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.model.UnidadeProdutora;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;
import com.atos.inventario.repositories.EmpregadoRepository;
import com.atos.inventario.repositories.LicitacaoRepository;
import com.atos.inventario.repositories.UnidadeProdutoraRepository;
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
	UnidadeProdutoraRepository unidadeProdutoraRepository;
	
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;

	@GetMapping("/licitacoes")
	public ResponseEntity<List<Licitacao>> listarLicitacao(@RequestBody(required=false) Map<String, String> filtro) {

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
		
//		List<Licitacao> licitacoes = licitacaoRepository.findAll().stream()
//				.filter(l -> l.getDocumentoEncaminhamento().equals(filtro.get("documentoEncaminhamento"))
//						&& l.getUnidadeProdutora().getSigla().equals(filtro.get("unidadeProdutora"))
//						&& l.getClassificacaoDocumental().getCodigoClassificacaoDocumental() == Integer
//								.parseInt(filtro.get("codigoClassificacaoDocumental"))
//						&& l.getDataLimite().equals(new Date(filtro.get("dataLimite")))
//						&& l.getNumeroProcessoLicitatorio().equals(filtro.get("numeroProcessoLicitatorio"))
//						&& l.getNumeroPec().equals(filtro.get("numeroPec"))
//						&& l.getObjetoResumido().equals(filtro.get("objetoResumido"))
//						&& l.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.get("idLocalizacao")))
//				.collect(Collectors.toList());
		
		List<Licitacao> licitacoes = licitacaoRepository.findAll();

		return ResponseEntity.ok(licitacoes);
	}

	@PostMapping("/cadastrarLicitacao")
	public ResponseEntity<Licitacao> cadastrarLicitacao(@RequestBody LicitacaoDTO licitacaoDto) {
		
		ModelMapper mapper = new ModelMapper();
		
		Licitacao licitacao = mapper.map(licitacaoDto, Licitacao.class);
		
		UnidadeProdutora unidadeProdutora = unidadeProdutoraRepository.findById(licitacaoDto.getUnidadeProdutoraId()).get();
		licitacao.setUnidadeProdutora(unidadeProdutora);
		
		Empregado empregado = empregadoRepository.findById(1L).get();
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
