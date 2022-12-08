package com.atos.inventario.controller;


import com.atos.inventario.model.PastaFuncional;
import com.atos.inventario.repositories.PastaFuncionalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class PastaFuncionalController {

	@Autowired
    private PastaFuncionalRepository pastaFuncionalRepository;

    @PostMapping(value = "/cadastrarPasta")
    public ResponseEntity<PastaFuncional> save(@RequestBody PastaFuncional toSave) {
        return ResponseEntity.ok(pastaFuncionalRepository.save(toSave));
    }

    @GetMapping(value = "/pastas")
    public ResponseEntity<List<PastaFuncional>> list(@RequestBody(required=false) Map<String, String> filtro) {
        // TODO organizar os filtros
        /*
            .stream()
            .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
            .collect(Collectors.toList())
        * */
        List<PastaFuncional> pastasFuncionais = pastaFuncionalRepository.findAll();

        return ResponseEntity.ok(pastasFuncionais);
    }
    
    @PostMapping(value="/cadastrapasta")
    public ResponseEntity<PastaFuncional> cadastrar(@RequestBody PastaFuncional pastaFuncional){
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
