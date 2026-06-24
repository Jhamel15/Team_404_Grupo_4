package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}