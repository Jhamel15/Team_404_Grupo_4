package com.example.practica.controller;

import com.example.practica.entity.TipodeBaja;
import com.example.practica.services.TipodeBajaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposbaja")
public class TipodeBajaController {

    private final TipodeBajaService service;

    public TipodeBajaController(TipodeBajaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipodeBaja> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipodeBaja> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipodeBaja guardar(@RequestBody TipodeBaja tipoBaja) {
        return service.guardar(tipoBaja);
    }

    @PutMapping("/{id}")
    public TipodeBaja actualizar(@PathVariable Long id, @RequestBody TipodeBaja tipoBaja) {
        return service.actualizar(id, tipoBaja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}