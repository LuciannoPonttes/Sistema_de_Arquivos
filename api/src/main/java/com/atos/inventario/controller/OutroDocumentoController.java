package com.atos.inventario.controller;


import com.atos.inventario.model.OutroDocumento;
import com.atos.inventario.repositories.OutroDocumentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "outros")
public class OutroDocumentoController {

    private OutroDocumentoRepository outroDocumentoRepository;

    @PostMapping()
    public ResponseEntity<OutroDocumento> save(@RequestBody OutroDocumento toSave) {
        return ResponseEntity.ok(outroDocumentoRepository.save(toSave));
    }

    @PostMapping(value = "/list")
    public ResponseEntity<List<OutroDocumento>> list(@RequestBody Map<String, String> filtro) {
        // TODO organizar os filtros
        /*
            .stream()
            .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
            .collect(Collectors.toList())
        * */
        List<OutroDocumento> outrosDocumentos = outroDocumentoRepository.findAll();
        return ResponseEntity.ok(outrosDocumentos);
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(long id) {
        outroDocumentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
