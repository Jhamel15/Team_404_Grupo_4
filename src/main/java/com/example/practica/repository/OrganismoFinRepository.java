package com.example.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entity.OrganismoFin;

@Repository
public interface OrganismoFinRepository extends JpaRepository<OrganismoFin, Long> {
}