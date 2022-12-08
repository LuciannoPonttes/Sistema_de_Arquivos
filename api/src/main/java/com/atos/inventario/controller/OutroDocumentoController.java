package com.atos.inventario.controller;


import com.atos.inventario.model.OutroDocumento;
import com.atos.inventario.repositories.OutroDocumentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class OutroDocumentoController {

	@Autowired
    private OutroDocumentoRepository outroDocumentoRepository;

    @PostMapping(value = "/cadastrarOutro")
    public ResponseEntity<OutroDocumento> save(@RequestBody OutroDocumento toSave) {
        return ResponseEntity.ok(outroDocumentoRepository.save(toSave));
    }

    @GetMapping(value = "/outros")
    public ResponseEntity<List<OutroDocumento>> list(@RequestBody(required=false) Map<String, String> filtro) {
        // TODO organizar os filtros
        /*
            .stream()
            .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
            .collect(Collectors.toList())
        * */
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
