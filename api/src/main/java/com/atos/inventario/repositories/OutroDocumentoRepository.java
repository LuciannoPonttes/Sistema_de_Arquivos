package com.atos.inventario.repositories;

import com.atos.inventario.model.OutroDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutroDocumentoRepository extends JpaRepository<OutroDocumento, Long> {

	OutroDocumento findById(long id);
}