package com.example.practica.controller;

import com.example.practica.entity.OficinaEntity;
import com.example.practica.services.OficinaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/oficina")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;

        if (oficinaService.listar().isEmpty()) {

            oficinaService.guardar(
                    new OficinaEntity(
        null,
        "FINANZAS",
        "ADMINISTRACION",
        "OF001",
        "OFICINA CENTRAL",
        "OFICINA PRINCIPAL",
        LocalDateTime.now(),
        "saul",
        "ACTIVO"
)
            );
        }
    }

    @GetMapping
    public List<OficinaEntity> listar() {
        return oficinaService.listar();
    }

    @PostMapping
    public OficinaEntity guardar(
            @RequestBody OficinaEntity oficina) {

        return oficinaService.guardar(oficina);
    }

    @PutMapping("/{id}")
    public OficinaEntity actualizar(
            @PathVariable Integer id,
            @RequestBody OficinaEntity datos) {

        return oficinaService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        oficinaService.eliminar(id);

        return "Oficina eliminada correctamente";
    }
}