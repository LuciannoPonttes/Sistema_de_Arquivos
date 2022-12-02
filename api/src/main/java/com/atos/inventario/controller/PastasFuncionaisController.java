package com.atos.inventario.controller;


import com.atos.inventario.model.Contrato;
import com.atos.inventario.repositories.ContratoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "pastas-funcionais")
public class PastasFuncionaisController {

    private ContratoRepository contratoRepository;

    @PostMapping()
    // TODO esta usando "Contrato"  enquanto não tem a model dele
    public ResponseEntity<Contrato> save(@RequestBody Contrato toSave) {
        Contrato contrato = contratoRepository.save(toSave);

        return ResponseEntity.ok(contrato);
    }

    @PostMapping(value = "/list")
    // TODO exemplo de filtro
    //      esta usando "Contrato"  enquanto não tem a model dele
    public ResponseEntity<List<Contrato>> list(@RequestBody Map<String, String> filtro) {
        List<Contrato> contratos = contratoRepository.findAll();

        return ResponseEntity.ok(contratos);
    }
}
