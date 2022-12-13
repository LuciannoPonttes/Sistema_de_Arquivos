package com.atos.inventario.controller;


import com.atos.inventario.atosdto.PastaFuncionalDTO;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.model.PastaFuncional;
import com.atos.inventario.model.UnidadeProdutora;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;
import com.atos.inventario.repositories.EmpregadoRepository;
import com.atos.inventario.repositories.PastaFuncionalRepository;
import com.atos.inventario.repositories.UnidadeProdutoraRepository;
import com.atos.inventario.services.LocalizacaoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class PastaFuncionalController {

	@Autowired
    private PastaFuncionalRepository pastaFuncionalRepository;
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
	
	@Autowired
	UnidadeProdutoraRepository unidadeProdutoraRepository;
	
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;

    @PostMapping(value = "/cadastrarPasta")
    public ResponseEntity<PastaFuncional> save(@RequestBody PastaFuncional toSave) {
        return ResponseEntity.ok(pastaFuncionalRepository.save(toSave));
    }

    @GetMapping(value = "/pastas")
    public ResponseEntity<List<PastaFuncional>> list(@RequestBody(required=false) Map<String, String> filtro) {

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
		
//		List<PastaFuncional> pastasFuncionais = pastaFuncionalRepository.findAll().stream()
//				.filter(p -> p.getDocumentoEncaminhamento().equals(filtro.get("documentoEncaminhamento"))
//						&& p.getUnidadeProdutora().getSigla().equals(filtro.get("unidadeProdutora"))
//						&& p.getClassificacaoDocumental().getCodigoClassificacaoDocumental() == Integer
//								.parseInt(filtro.get("codigoClassificacaoDocumental"))
//						&& p.getDataLimite().equals(new Date(filtro.get("dataLimite")))
//						&& p.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.get("idLocalizacao")))
//				.collect(Collectors.toList());
    	
        List<PastaFuncional> pastasFuncionais = pastaFuncionalRepository.findAll();

        return ResponseEntity.ok(pastasFuncionais);
    }
    
    @PostMapping(value="/cadastrapasta")
    public ResponseEntity<PastaFuncional> cadastrar(@RequestBody PastaFuncionalDTO pastaFuncionalDto){
    	
		ModelMapper mapper = new ModelMapper();

		PastaFuncional pastaFuncional = mapper.map(pastaFuncionalDto, PastaFuncional.class);

		UnidadeProdutora unidadeProdutora = unidadeProdutoraRepository.findById(pastaFuncionalDto.getUnidadeProdutoraId()).get();
		pastaFuncional.setUnidadeProdutora(unidadeProdutora);

		Empregado empregado = empregadoRepository.findById(1L).get();
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
        pastaFuncionalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
