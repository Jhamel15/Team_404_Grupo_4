package com.example.practica.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NombreController {

    private List<String> nombres = new ArrayList<>();

    @GetMapping("/nombre")
    public String mostrarNombreCompleto() {
        return "Jhamel Javier Pinto Ubaldes";
    }

    @GetMapping("/nombres")
    public List<String> obtenerNombres() {
        return nombres;
    }

    @PostMapping("/nombre")
    public String agregarNombre(@RequestBody String nombre) {
        nombres.add(nombre);
        return "Nombre agregado: " + nombre;
    }
}