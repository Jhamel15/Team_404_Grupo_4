package com.example.practica.controller;

import com.example.practica.entity.Mes;
import com.example.practica.services.MesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meses")
public class MesController {

    private final MesService mesService;

    public MesController(MesService mesService) {
        this.mesService = mesService;
    }

    @GetMapping
    public List<Mes> listar() {
        return mesService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mes> buscarPorId(@PathVariable Integer id) {
        return mesService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mes guardar(@RequestBody Mes mes) {
        return mesService.guardar(mes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mes> actualizar(@PathVariable Integer id, @RequestBody Mes datos) {
        Mes mesActualizado = mesService.actualizar(id, datos);

        if (mesActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mesActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        boolean eliminado = mesService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Mes eliminado correctamente");
    }
}
