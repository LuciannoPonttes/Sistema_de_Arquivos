package com.atos.inventario.repositories;

import com.atos.inventario.model.ClassificacaoDocumental;
import com.atos.inventario.model.PastaFuncional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificacaoDocumentalRepository extends JpaRepository<ClassificacaoDocumental, Long> {

}