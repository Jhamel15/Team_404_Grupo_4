package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}