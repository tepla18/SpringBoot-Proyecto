package com.example.prestamos.repository;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InterfaceTipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {

    // Buscar por nombre de documento
    @Query("SELECT t FROM TipoDocumento t WHERE t.nombreDocumento = ?1")
    ArrayList<TipoDocumento> findByNombre(String nombreDocumento);



}
