package com.example.practica.controller;

import com.example.practica.entity.ClaDept;
import com.example.practica.services.ClaDeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class ClaDeptController {

    private final ClaDeptService claDeptService;

    public ClaDeptController(ClaDeptService claDeptService) {
        this.claDeptService = claDeptService;
    }

    @GetMapping
    public List<ClaDept> obtenerTodos() {
        return claDeptService.obtenerTodos();
    }

    @PostMapping
    public ClaDept guardar(@RequestBody ClaDept depto) {
        return claDeptService.guardar(depto);
    }

    @PutMapping("/{id}")
    public ClaDept actualizar(@PathVariable Long id, @RequestBody ClaDept deptoActualizado) {
        return claDeptService.actualizar(id, deptoActualizado);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return claDeptService.eliminar(id);
    }
}