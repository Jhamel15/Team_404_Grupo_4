package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entity.ClaDept;

@Repository
public interface ClaDeptRepository extends JpaRepository<ClaDept, Long> {
}