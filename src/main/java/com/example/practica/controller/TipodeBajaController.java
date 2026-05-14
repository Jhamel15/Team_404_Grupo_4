package com.example.practica.controller;

import com.example.practica.model.TipodeBaja;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tiposbaja")
public class TipodeBajaController {

    private List<TipodeBaja> tiposBaja = new ArrayList<>();

    // Datos precargados al iniciar la aplicación
    @PostConstruct
    public void init() {
        tiposBaja.add(new TipodeBaja(1L, "Venta", "Activo retirado por venta"));
        tiposBaja.add(new TipodeBaja(2L, "Robo", "Activo retirado por robo"));
        tiposBaja.add(new TipodeBaja(3L, "Roto", "Activo retirado por daño o rotura"));
        tiposBaja.add(new TipodeBaja(4L, "Error", "Activo retirado por error administrativo"));
    }

    // GET todos los tipos de baja
    @GetMapping
    public List<TipodeBaja> getAll() {
        return tiposBaja;
    }

    // GET tipo de baja por id
    @GetMapping("/{id}")
    public TipodeBaja getById(@PathVariable Long id) {
        Optional<TipodeBaja> tipo = tiposBaja.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
        return tipo.orElse(null);
    }

    // POST crear nuevo tipo de baja
    @PostMapping
    public TipodeBaja create(@RequestBody TipodeBaja tipoBaja) {
        tiposBaja.add(tipoBaja);
        return tipoBaja;
    }

    // PUT actualizar tipo de baja
    @PutMapping("/{id}")
    public TipodeBaja update(@PathVariable Long id, @RequestBody TipodeBaja tipoBajaActualizado) {
        for (int i = 0; i < tiposBaja.size(); i++) {
            TipodeBaja t = tiposBaja.get(i);
            if (t.getId().equals(id)) {
                tiposBaja.set(i, tipoBajaActualizado);
                return tipoBajaActualizado;
            }
        }
        return null;
    }

    // DELETE tipo de baja por id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        tiposBaja.removeIf(t -> t.getId().equals(id));
        return "Tipo de baja con id " + id + " eliminado";
    }
}

