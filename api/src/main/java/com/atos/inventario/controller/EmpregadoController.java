package com.atos.inventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.atos.inventario.atosdto.EmpregadoDTO;
import com.atos.inventario.atosdto.FiltroPesquisaEmpregadoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atos.inventario.model.Empregado;
import com.atos.inventario.repositories.EmpregadoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmpregadoController {

	@Autowired
	private EmpregadoRepository empregadoRepository;

	@GetMapping(value = "/empregado" )
	public Optional<Empregado> buscarEmpregado(@RequestParam String matricula, @RequestParam String senha) {

		return empregadoRepository.findByMatriculaSenha(matricula, senha);
	}

	@PostMapping(value = "/empregados")
	public ResponseEntity<List<EmpregadoDTO>> listarEmpregados(@RequestBody(required = false) FiltroPesquisaEmpregadoDTO filtro){
		List<EmpregadoDTO> listEmpregados = new ArrayList<>();
		List<Empregado> empregados = empregadoRepository.findByAtivoTrue().stream()
				.filter( filtro.getNome() != null ? e -> e.getNome().contains(filtro.getNome()) : e -> true )
				.filter( filtro.getMatricula() != null ? e -> e.getMatricula().contains(filtro.getMatricula()) : e -> true)
				.filter( filtro.getEmail() != null ? e -> e.getEmail().contains(filtro.getEmail()) : e -> true )
				.filter( filtro.getUnidadeDepartamento() != null ? e -> e.getDepartamento().contains(filtro.getUnidadeDepartamento()) : e -> true )
				.collect(Collectors.toList());

		for (Empregado emp : empregados){
			listEmpregados.add(new EmpregadoDTO(
				emp.getIdEmpregado(),
				emp.getNome(),
				emp.getMatricula(),
				emp.getEmail(),
				emp.getDepartamento()
			));
		}
		
		return ResponseEntity.ok(listEmpregados);
	}

	@PostMapping("/cadastrarEmpregado")
	public ResponseEntity<Empregado> cadastrarEmpregado(@RequestBody EmpregadoDTO empregadoDTO){
		ModelMapper mapper = new ModelMapper();

		Empregado empregado = mapper.map(empregadoDTO, Empregado.class);
//		empregado.setAtivo(true);
		empregado.setSenha(empregadoDTO.getMatricula());

		return ResponseEntity.ok(empregadoRepository.save(empregado));
	}

	@PostMapping(value = "/desativarEmpregado")
	public ResponseEntity<Void> desativaEmpregado(@RequestParam("id") Long id){

		Optional<Empregado> empregado = empregadoRepository.findById(id);
		if (empregado.isPresent()){
			empregado.get().setAtivo(false);
			empregadoRepository.save(empregado.get());
		}

		return ResponseEntity.noContent().build();
	}
}	
