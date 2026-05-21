package com.example.practica.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mes")
public class Mes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codmes;

    @Column(nullable = false, length = 50)
    private String nommes;

    @Column(nullable = false)
    private Integer numero;

    public Mes() {
    }

    public Mes(Integer codmes, String nommes, Integer numero) {
        this.codmes = codmes;
        this.nommes = nommes;
        this.numero = numero;
    }

    public Integer getCodmes() {
        return codmes;
    }

    public void setCodmes(Integer codmes) {
        this.codmes = codmes;
    }

    public String getNommes() {
        return nommes;
    }

    public void setNommes(String nommes) {
        this.nommes = nommes;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}