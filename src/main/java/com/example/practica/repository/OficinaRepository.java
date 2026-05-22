package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entity.Oficina;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Integer> {

}