package com.atos.inventario.services;

import com.atos.inventario.atosdto.LocalizacaoDTO;
import com.atos.inventario.model.Localizacao;

public interface LocalizacaoService {

	public Localizacao validaLocalizacao(LocalizacaoDTO dto);
}
