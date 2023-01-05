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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.atosdto.FiltroPesquisaDTO;
import com.atos.inventario.atosdto.PastaFuncionalDTO;
import com.atos.inventario.enums.UnidadeProdutoraEnum;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.model.PastaFuncional;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;
import com.atos.inventario.repositories.EmpregadoRepository;
import com.atos.inventario.repositories.PastaFuncionalRepository;
import com.atos.inventario.services.LocalizacaoService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class PastaFuncionalController {

	@Autowired
    private PastaFuncionalRepository pastaFuncionalRepository;
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
	
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;

    @PostMapping(value = "/pasta/listar")
    public ResponseEntity<List<PastaFuncional>> list(@RequestBody(required=false) FiltroPesquisaDTO filtro) {

		// TODO organizar os filtros
		/* 
		 * PastaFuncional.documentoEncaminhamento 
		 * PastaFuncional.unidadeProdutora
		 * PastaFuncional.classificacaoDocumental
		 * PastaFuncional.dataLimite
 		 * Empregado.nome
 		 * Empregado.matricula
		 * PastaFuncional.localizacao
		 * Empregado.departamento
		 * 
		 * */
		
		List<PastaFuncional> pastasFuncionais = pastaFuncionalRepository.findAll().stream()
				.filter(filtro.getUnidadeProdutora() != null ? p -> p.getUnidadeProdutora().getCodigo().equals(filtro.getUnidadeProdutora()) : p -> true)
				.filter(filtro.getClassificacaoDocumental() != null ? p -> p.getClassificacaoDocumental().getCodigoClassificacaoDocumental().equals(filtro.getClassificacaoDocumental()) : p -> true)
				.filter(filtro.getDataLimite() != null ? p -> p.getDataLimite().equals(filtro.getDataLimite()) : p -> true)
				.filter(filtro.getLocalizacao() != null ? p -> p.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.getLocalizacao()) : p -> true)
				.collect(Collectors.toList());
    	
        return ResponseEntity.ok(pastasFuncionais);
    }
    
    @PostMapping(value="/pasta/cadastrar")
    public ResponseEntity<PastaFuncional> cadastrar(@RequestBody PastaFuncionalDTO pastaFuncionalDto){
    	
		ModelMapper mapper = new ModelMapper();

		PastaFuncional pastaFuncional = mapper.map(pastaFuncionalDto, PastaFuncional.class);

		UnidadeProdutoraEnum unidadeProdutora = UnidadeProdutoraEnum.getByCodigo(pastaFuncionalDto.getUnidadeProdutoraId());
		pastaFuncional.setUnidadeProdutora(unidadeProdutora);
		
		Empregado empregado = empregadoRepository.findById(pastaFuncionalDto.getEmpregadoId()).get();
		pastaFuncional.setEmpregado(empregado);

		ClassificacaoDocumental classificacaoDocumental = classificacaoDocumentalRepository.findById(pastaFuncionalDto.getClassificacaoDocumentalId()).get();
		pastaFuncional.setClassificacaoDocumental(classificacaoDocumental);

		Localizacao localizacao = localizacaoService.validaLocalizacao(pastaFuncionalDto.getLocalizacao());
		pastaFuncional.setLocalizacao(localizacao);
    	
    	PastaFuncional pasta = pastaFuncionalRepository.save(pastaFuncional);
    	return ResponseEntity.ok(pasta);
    }
    
    @GetMapping(value= "/pasta/{id}")
    public ResponseEntity<PastaFuncional> getById(@PathVariable long id){
    	PastaFuncional result = pastaFuncionalRepository.findById(id);
    	if (result != null) {
    		return ResponseEntity.ok(result);
    	} else {
    		return ResponseEntity.notFound().build();
    	}
    }

    @DeleteMapping(value="/pasta/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
    	PastaFuncional result = pastaFuncionalRepository.findById(id);
    	if (result != null) {
    		pastaFuncionalRepository.delete(result);
    		return ResponseEntity.noContent().build();
    	} else {
    		return ResponseEntity.notFound().build();
    	}
    }
}
