package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica.entity.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {
}