package com.atos.inventario.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.inventario.atosdto.FiltroRelatorioDocumentoUnidadeDTO;
import com.atos.inventario.atosdto.RelatorioDocumentoUnidadeDTO;
import com.atos.inventario.services.RelatorioService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RelatorioController {
	
	@Autowired
	RelatorioService relatorioService;
	
	@GetMapping("/relatorio1")
	public ResponseEntity<RelatorioDocumentoUnidadeDTO> gerarRelatorio1(@RequestBody FiltroRelatorioDocumentoUnidadeDTO filtro) {	
		return ResponseEntity.ok(relatorioService.gerarRelatorio1(filtro));
	}

}
