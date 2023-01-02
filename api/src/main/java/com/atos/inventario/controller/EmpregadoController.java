package com.atos.inventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.atos.inventario.atosdto.EmpregadoDTO;
import com.atos.inventario.atosdto.FiltroPesquisaEmpregadoDTO;
import com.atos.inventario.atosdto.LoginRequestDTO;
import com.atos.inventario.atosdto.LoginResponseDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import com.atos.inventario.model.Empregado;
import com.atos.inventario.repositories.EmpregadoRepository;
import com.atos.inventario.security.JwtUtils;
import com.atos.inventario.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmpregadoController {

	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/empregado" )
	public ResponseEntity<Empregado> buscarEmpregado(@RequestParam String matricula, @RequestParam String senha) {
		Optional<Empregado> empregado = empregadoRepository.findByMatriculaSenha(matricula, senha);
		if (empregado.isPresent()) {
			return ResponseEntity.ok(empregado.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	
	}

	@PostMapping(value = "/empregado/listar")
	public ResponseEntity<List<EmpregadoDTO>> listarEmpregados(@RequestBody(required = false) FiltroPesquisaEmpregadoDTO filtro){

		List<Empregado> empregados = new ArrayList<>();
		if (filtro == null) {
			empregados = empregadoRepository.findAll();
		} else {
		    empregados = empregadoRepository.findByAtivoTrue().stream()
				.filter( filtro.getNome() != null ? e -> e.getNome().toLowerCase().contains(filtro.getNome().toLowerCase()) : e -> true )
				.filter( filtro.getMatricula() != null ? e -> e.getMatricula().toLowerCase().contains(filtro.getMatricula().toLowerCase()) : e -> true)
				.filter( filtro.getEmail() != null ? e -> e.getEmail().toLowerCase().contains(filtro.getEmail().toLowerCase()) : e -> true )
				.filter( filtro.getUnidadeDepartamento() != null ? e -> e.getDepartamentoDesc().toLowerCase().contains(filtro.getUnidadeDepartamento().toLowerCase()) : e -> true )
				.collect(Collectors.toList());
		}
		
		if (empregados.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		ModelMapper mapper = new ModelMapper();
		List<EmpregadoDTO> listEmpregados = empregados.stream()
				  .map(x -> mapper.map(x, EmpregadoDTO.class))
				  .collect(Collectors.toList());
		
		return ResponseEntity.ok(listEmpregados);
	}

	@PostMapping("/empregado/cadastrar")
	public ResponseEntity<Empregado> cadastrarEmpregado(@RequestBody EmpregadoDTO empregadoDTO){
		ModelMapper mapper = new ModelMapper();

		Empregado empregado = mapper.map(empregadoDTO, Empregado.class);
		empregado.setSenha(empregadoDTO.getMatricula());

		return ResponseEntity.ok(empregadoRepository.save(empregado));
	}


	@PostMapping(value = "/empregado/{id}/ativar")
	public ResponseEntity<Void> ativaEmpregado(@RequestParam("id") Long id){

		Optional<Empregado> empregado = empregadoRepository.findById(id);
		if (empregado.isPresent()){
			empregado.get().setAtivo(true);
			empregadoRepository.save(empregado.get());
		} else {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}

	
	@PostMapping(value = "/empregado/{id}/desativar")
	public ResponseEntity<Void> desativaEmpregado(@RequestParam("id") Long id){

		Optional<Empregado> empregado = empregadoRepository.findById(id);
		if (empregado.isPresent()){
			empregado.get().setAtivo(false);
			empregadoRepository.save(empregado.get());
		} else {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getMatricula(), loginRequest.getSenha(),new ArrayList<>());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.add(AUTHORIZATION_HEADER, "Bearer " + jwt);
	      
		return new ResponseEntity<>(new LoginResponseDTO(jwt), httpHeaders, HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<Empregado> getActualUser() {
		Optional<Empregado> p = userService.getUserWithAuthorities();
		if (p.isPresent()) {
			return ResponseEntity.ok(p.get());
		} else { 
			return ResponseEntity.notFound().build();
		}
	}
}	
