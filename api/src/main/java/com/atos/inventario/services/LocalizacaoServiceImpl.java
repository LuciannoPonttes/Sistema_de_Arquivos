package com.atos.inventario.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.inventario.atosdto.LocalizacaoDTO;
import com.atos.inventario.model.Localizacao;
import com.atos.inventario.repositories.LocalizacaoRepository;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService{

	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@Override
	public Localizacao validaLocalizacao(LocalizacaoDTO dto) {
		ModelMapper mapper = new ModelMapper();

		List<Localizacao> lista = localizacaoRepository.findAll()
				.stream()
				.filter(x -> x.getEndereco().equals(dto.getEndereco()))
				.filter(x -> x.getPredio().equals(dto.getPredio()))
				.filter(x -> x.getSala().equals(dto.getSala()))
				.filter(x -> x.getBloco().equals(dto.getBloco()))
				.filter(x -> x.getPosicao().equals(dto.getPosicao()))
				.filter(x -> x.getNumeroCaixa().equals(dto.getNumeroCaixa()))
				.collect(Collectors.toList());
		
		
		if (lista.size() > 0 ) {
			return lista.get(0);
		}
		
		Localizacao novaLocalizacao = mapper.map(dto, Localizacao.class);
		Localizacao localizacao =localizacaoRepository.save(novaLocalizacao);
		
		return localizacao;
	}

}
