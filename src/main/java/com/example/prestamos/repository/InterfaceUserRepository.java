package com.example.prestamos.repository;

import com.example.prestamos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Integer> {

    // Validar credenciales en login
    @Query("SELECT u FROM User u WHERE u.correoElectronico = ?1 and u.password = ?2")
    ArrayList<User> validaCredenciales(String usuario, String password);

    // validar que el correo no se repita
    @Query("SELECT u FROM User u WHERE u.correoElectronico = ?1")
    ArrayList<User> validaCorreo(String correoElectronico);
}
