package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.entity.Mes;

public interface MesRepository extends JpaRepository<Mes, Integer> {
}