package com.example.practica.repository;

import com.example.practica.entity.TipodeBaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipodeBajaRepository extends JpaRepository<TipodeBaja, Long> {
}
