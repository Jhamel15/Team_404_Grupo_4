package com.example.practica.repository;

import com.example.practica.entity.OficinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OficinaRepository extends JpaRepository<OficinaEntity, Integer> {

}