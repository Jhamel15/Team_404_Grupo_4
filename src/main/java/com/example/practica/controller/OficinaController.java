package com.example.practica.controller;

import com.example.practica.entity.Oficina;
import com.example.practica.services.OficinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficina")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {

        this.oficinaService = oficinaService;

        // DATOS INICIALES
        if (oficinaService.listar().isEmpty()) {

            oficinaService.guardar(
                    new Oficina(null,
                            "Oficina Administrativa",
                            "Área principal",
                            "Activo"));

            oficinaService.guardar(
                    new Oficina(null,
                            "Área Financiera",
                            "Control financiero",
                            "Activo"));

            oficinaService.guardar(
                    new Oficina(null,
                            "Dirección General",
                            "Gerencia institucional",
                            "Activo"));
        }
    }

    @GetMapping
    public List<Oficina> listar() {
        return oficinaService.listar();
    }

    @GetMapping("/{id}")
    public Oficina buscarPorId(@PathVariable Integer id) {
        return oficinaService.buscarPorId(id);
    }

    @PostMapping
    public Oficina guardar(@RequestBody Oficina oficina) {
        return oficinaService.guardar(oficina);
    }

    @PutMapping("/{id}")
    public Oficina actualizar(@PathVariable Integer id,
                              @RequestBody Oficina datos) {

        return oficinaService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        oficinaService.eliminar(id);

        return "Oficina eliminada correctamente";
    }
}