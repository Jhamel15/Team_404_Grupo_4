package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entity.TipodeBaja;

@Repository
public interface TipodeBajaRepository extends JpaRepository<TipodeBaja, Long> {
}