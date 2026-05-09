package com.example.practica.controller;

import com.example.practica.model.Estado;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private List<Estado> listaEstados = new ArrayList<>();

    public EstadoController() {

        listaEstados.add(new Estado(1, "Bueno"));
        listaEstados.add(new Estado(2, "Regular"));
        listaEstados.add(new Estado(3, "Malo"));
        listaEstados.add(new Estado(4, "En mantenimiento"));

    }

    @GetMapping
    public List<Estado> listar() {
        return listaEstados;
    }

    @PostMapping
    public Estado guardar(@RequestBody Estado estado) {
        listaEstados.add(estado);
        return estado;
    }

    @PutMapping("/{id}")
    public Estado actualizar(@PathVariable Integer id, @RequestBody Estado datos) {

        for (Estado estado : listaEstados) {

            if (estado.getCodestado().equals(id)) {

                estado.setNomestado(datos.getNomestado());

                return estado;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        listaEstados.removeIf(estado -> estado.getCodestado().equals(id));

        return "Estado eliminado correctamente";
    }
}