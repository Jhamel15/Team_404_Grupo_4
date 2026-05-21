package com.example.practica.controller;

import com.example.practica.entity.TipodeBaja;
import com.example.practica.service.TipodeBajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposbaja")
@CrossOrigin(origins = "*")
public class TipodeBajaController {

    @Autowired
    private TipodeBajaService service;

    @GetMapping
    public List<TipodeBaja> getAll() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipodeBaja> getById(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipodeBaja create(@RequestBody TipodeBaja tipoBaja) {
        return service.guardar(tipoBaja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipodeBaja> update(@PathVariable Long id, @RequestBody TipodeBaja tipoBajaActualizado) {
        try {
            TipodeBaja actualizado = service.actualizar(id, tipoBajaActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

