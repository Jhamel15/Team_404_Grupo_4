package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entity.Mes;

@Repository
public interface MesRepository extends JpaRepository<Mes, Integer> {
}