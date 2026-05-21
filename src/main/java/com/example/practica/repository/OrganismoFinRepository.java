package com.example.practica.repository;

import com.example.practica.Entity.OrganismoFin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismoFinRepository extends JpaRepository<OrganismoFin, Long> {
}