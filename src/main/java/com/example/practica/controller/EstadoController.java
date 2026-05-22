package com.example.practica.controller;

import com.example.practica.entity.Estado;
import com.example.practica.services.EstadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;

        // DATOS INICIALES
        if (estadoService.listar().isEmpty()) {

            estadoService.guardar(new Estado(null, "Bueno"));
            estadoService.guardar(new Estado(null, "Regular"));
            estadoService.guardar(new Estado(null, "Malo"));
            estadoService.guardar(new Estado(null, "En mantenimiento"));

        }
    }

    @GetMapping
    public List<Estado> listar() {
        return estadoService.listar();
    }

    @PostMapping
    public Estado guardar(@RequestBody Estado estado) {
        return estadoService.guardar(estado);
    }

    @PutMapping("/{id}")
    public Estado actualizar(@PathVariable Integer id,
            @RequestBody Estado datos) {

        return estadoService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        estadoService.eliminar(id);

        return "Estado eliminado correctamente";
    }
}