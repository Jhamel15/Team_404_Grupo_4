package com.example.practica.controller;

import com.example.practica.entity.ClaDept;
import com.example.practica.services.ClaDeptService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<ClaDept> buscarPorId(@PathVariable Long id) {
        ClaDept departamento = claDeptService.buscarPorId(id);

        if (departamento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departamento);
    }

    @PostMapping
    public ResponseEntity<ClaDept> guardar(@RequestBody ClaDept depto) {
        return ResponseEntity.ok(claDeptService.guardar(depto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaDept> actualizar(@PathVariable Long id, @RequestBody ClaDept deptoActualizado) {
        ClaDept actualizado = claDeptService.actualizar(id, deptoActualizado);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        boolean eliminado = claDeptService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Departamento eliminado correctamente");
    }
}