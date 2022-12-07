package com.atos.inventario.repositories;

import com.atos.inventario.model.Localizacao;
import com.atos.inventario.model.PastaFuncional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

}