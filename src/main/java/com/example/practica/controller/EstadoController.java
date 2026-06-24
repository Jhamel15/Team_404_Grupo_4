package com.example.practica.controller;

import com.example.practica.entity.Estado;
import com.example.practica.services.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> listar() {
        return estadoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Integer id) {
        Estado estado = estadoService.buscarPorId(id);

        if (estado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public Estado guardar(@RequestBody Estado estado) {
        return estadoService.guardar(estado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizar(@PathVariable Integer id, @RequestBody Estado datos) {
        Estado estadoActualizado = estadoService.actualizar(id, datos);

        if (estadoActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estadoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        boolean eliminado = estadoService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Estado eliminado correctamente");
    }
}
