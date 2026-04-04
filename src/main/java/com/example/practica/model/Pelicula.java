package com.example.practica.model;

public class Pelicula {

    private String titulo;
    private String director;
    private int año;
    private int duracion;
    private String genero;
    private String sinopsis;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, int año, int duracion, String genero, String sinopsis) {
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    // GETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAño() {
        return año;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}