package com.example.practica.repository;

import com.example.practica.Entity.ClaDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaDeptRepository extends JpaRepository<ClaDept, Long> {
}