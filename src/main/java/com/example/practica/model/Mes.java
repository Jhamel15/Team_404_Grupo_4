package com.example.practica.model;

public class Mes {

    private Long id;
    private String nombre;
    private int numero;

    public Mes() {
    }

    public Mes(Long id, String nombre, int numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}