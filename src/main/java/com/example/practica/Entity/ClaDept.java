package com.example.practica.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
public class ClaDept {

    @Id
    private Long id;
    private String codigo;
    private String nombre;
    private String sigla;

    public ClaDept() {
    }

    public ClaDept(Long id, String codigo, String nombre, String sigla) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}