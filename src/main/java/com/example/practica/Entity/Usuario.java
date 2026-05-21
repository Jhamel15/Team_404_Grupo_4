package com.example.practica.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codusuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String password;

    public Usuario() {
    }

    public Usuario(Integer codusuario, String nombre, String correo, String password) {
        this.codusuario = codusuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Integer getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}