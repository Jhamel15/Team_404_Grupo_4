package com.example.practica.model;

public class Oficina {

    private int codigo;
    private String nombre;
    private String observaciones;

   
    public Oficina() {
    }

    public Oficina(int codigo, String nombre, String observaciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.observaciones = observaciones;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}