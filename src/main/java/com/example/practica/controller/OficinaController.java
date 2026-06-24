package com.example.practica.controller;

import com.example.practica.entity.Oficina;
import com.example.practica.services.OficinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficina")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping
    public List<Oficina> listar() {
        return oficinaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oficina> buscarPorId(@PathVariable Integer id) {
        Oficina oficina = oficinaService.buscarPorId(id);

        if (oficina == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oficina);
    }

    @PostMapping
    public Oficina guardar(@RequestBody Oficina oficina) {
        return oficinaService.guardar(oficina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oficina> actualizar(@PathVariable Integer id, @RequestBody Oficina datos) {
        Oficina oficinaActualizada = oficinaService.actualizar(id, datos);

        if (oficinaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oficinaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        boolean eliminado = oficinaService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Oficina eliminada correctamente");
    }
}
