package com.example.practica.controller;

import com.example.practica.Entity.OrganismoFin;
import com.example.practica.services.OrganismoFinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/organismos-fin")
@CrossOrigin(origins = "*")
public class OrganismoFinController {

    private final OrganismoFinService service;

    public OrganismoFinController(OrganismoFinService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrganismoFin> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganismoFin> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrganismoFin guardar(@RequestBody OrganismoFin organismoFin) {
        return service.guardar(organismoFin);
    }

    @PutMapping("/{id}")
    public OrganismoFin actualizar(@PathVariable Long id,
                                   @RequestBody OrganismoFin organismoFin) {

        return service.actualizar(id, organismoFin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}