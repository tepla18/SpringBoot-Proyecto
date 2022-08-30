package com.example.prestamos.repository;

import com.example.prestamos.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceTipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
