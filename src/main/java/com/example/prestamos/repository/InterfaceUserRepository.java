package com.example.prestamos.repository;

import com.example.prestamos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Integer> {
}
