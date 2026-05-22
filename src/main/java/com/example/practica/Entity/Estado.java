package com.example.practica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codestado;

    @Column(nullable = false)
    private String nomestado;

    public Estado() {
    }

    public Estado(Integer codestado, String nomestado) {
        this.codestado = codestado;
        this.nomestado = nomestado;
    }

    public Integer getCodestado() {
        return codestado;
    }

    public void setCodestado(Integer codestado) {
        this.codestado = codestado;
    }

    public String getNomestado() {
        return nomestado;
    }

    public void setNomestado(String nomestado) {
        this.nomestado = nomestado;
    }
}