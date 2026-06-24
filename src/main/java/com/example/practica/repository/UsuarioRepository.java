package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}