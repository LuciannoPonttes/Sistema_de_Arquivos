package com.atos.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.repositories.ClassificacaoDocumentalRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClassificacaoDocumentalController {
	
	@Autowired
	ClassificacaoDocumentalRepository classificacaoDocumentalRepository;
	
    @GetMapping(value = "/classificacoes")
    public ResponseEntity<List<ClassificacaoDocumental>> list() {
    	return ResponseEntity.ok(classificacaoDocumentalRepository.findAll());
    }

}
