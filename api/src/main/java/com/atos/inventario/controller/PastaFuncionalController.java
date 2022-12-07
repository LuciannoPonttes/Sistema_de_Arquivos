package com.atos.inventario.controller;


import com.atos.inventario.model.PastaFuncional;
import com.atos.inventario.repositories.PastaFuncionalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "pastas-funcionais")
public class PastaFuncionalController {

    private PastaFuncionalRepository pastaFuncionalRepository;

    @PostMapping()
    public ResponseEntity<PastaFuncional> save(@RequestBody PastaFuncional toSave) {
        return ResponseEntity.ok(pastaFuncionalRepository.save(toSave));
    }

    @PostMapping(value = "/list")
    public ResponseEntity<List<PastaFuncional>> list(@RequestBody Map<String, String> filtro) {
        // TODO organizar os filtros
        /*
            .stream()
            .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
            .collect(Collectors.toList())
        * */
        List<PastaFuncional> pastasFuncionais = pastaFuncionalRepository.findAll();

        return ResponseEntity.ok(pastasFuncionais);
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(long id) {
        pastaFuncionalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
