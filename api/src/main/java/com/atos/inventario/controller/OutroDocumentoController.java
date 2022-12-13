package com.atos.inventario.controller;


import com.atos.inventario.atosdto.OutroDocumentoDTO;
import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.Empregado;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.model.OutroDocumento;
import com.atos.inventario.model.UnidadeProdutora;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;
import com.atos.inventario.repositories.EmpregadoRepository;
import com.atos.inventario.repositories.OutroDocumentoRepository;
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
public class OutroDocumentoController {

	@Autowired
    private OutroDocumentoRepository outroDocumentoRepository;
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
	
	@Autowired
	UnidadeProdutoraRepository unidadeProdutoraRepository;
	
	@Autowired
	EmpregadoRepository empregadoRepository;
	
	@Autowired
	LocalizacaoService localizacaoService;

    @PostMapping(value = "/cadastrarOutro")
    public ResponseEntity<OutroDocumento> save(@RequestBody OutroDocumentoDTO outroDocumentoDto) {
    	
    	ModelMapper mapper = new ModelMapper();
		
    	OutroDocumento outroDocumento = mapper.map(outroDocumentoDto, OutroDocumento.class);
		
		UnidadeProdutora unidadeProdutora = unidadeProdutoraRepository.findById(outroDocumentoDto.getUnidadeProdutoraId()).get();
		outroDocumento.setUnidadeProdutora(unidadeProdutora);
		
		Empregado empregado = empregadoRepository.findById(outroDocumentoDto.getEmpregadoId()).get();
		outroDocumento.setEmpregado(empregado);
		
		ClassificacaoDocumental classificacaoDocumental = classificacaoDocumentalRepository.findById(outroDocumentoDto.getClassificacaoDocumentalId()).get();
		outroDocumento.setClassificacaoDocumental(classificacaoDocumental);
		
		Localizacao localizacao = localizacaoService.validaLocalizacao(outroDocumentoDto.getLocalizacao());
		outroDocumento.setLocalizacao(localizacao);
		
        return ResponseEntity.ok(outroDocumentoRepository.save(outroDocumento));
    }

    @GetMapping(value = "/outros")
    public ResponseEntity<List<OutroDocumento>> list(@RequestBody(required=false) Map<String, String> filtro) {

		// TODO organizar os filtros
		/* 
		 * OutroDocumento.documentoEncaminhamento 
		 * OutroDocumento.unidadeProdutora
		 * OutroDocumento.classificacaoDocumental
		 * OutroDocumento.dataLimite
		 * OutroDocumento.objetoResumido
		 * OutroDocumento.localizacao
		 * Empregado.departamento
		 * 
		 * */
		
//		List<OutroDocumento> outrosDocumentos = outroDocumentoRepository.findAll().stream()
//				.filter(o -> o.getDocumentoEncaminhamento().equals(filtro.get("documentoEncaminhamento"))
//						&& o.getUnidadeProdutora().getSigla().equals(filtro.get("unidadeProdutora"))
//						&& o.getClassificacaoDocumental().getCodigoClassificacaoDocumental() == Integer
//								.parseInt(filtro.get("codigoClassificacaoDocumental"))
//						&& o.getDataLimite().equals(new Date(filtro.get("dataLimite")))
//						&& o.getObjetoResumido().equals(filtro.get("objetoResumido"))
//						&& o.getLocalizacao().getIdLocalizacao() == Long.parseLong(filtro.get("idLocalizacao")))
//				.collect(Collectors.toList());
    	
        List<OutroDocumento> outrosDocumentos = outroDocumentoRepository.findAll();
        return ResponseEntity.ok(outrosDocumentos);
    }

    @GetMapping(value = "/outro/{id}")
    public ResponseEntity<OutroDocumento> getById(@PathVariable long id){
    	OutroDocumento result = outroDocumentoRepository.findById(id);
    	if ( result != null) {
    		return ResponseEntity.ok(result);
    	} else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    @DeleteMapping(value = "/outro/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        outroDocumentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
