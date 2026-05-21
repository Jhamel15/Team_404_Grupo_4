package com.example.practica.services;

import com.example.practica.entity.TipodeBaja;
import com.example.practica.repository.TipodeBajaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipodeBajaService {

    @Autowired
    private TipodeBajaRepository repository;

    public List<TipodeBaja> listarTodos() {
        return repository.findAll();
    }

    public Optional<TipodeBaja> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public TipodeBaja guardar(TipodeBaja tipo) {
        return repository.save(tipo);
    }

    public TipodeBaja actualizar(Long id, TipodeBaja tipoDetalles) {
        return repository.findById(id).map(tipo -> {
            tipo.setNombre(tipoDetalles.getNombre());
            tipo.setDescripcion(tipoDetalles.getDescripcion());
            return repository.save(tipo);
        }).orElseThrow(() -> new RuntimeException("Tipo de Baja no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            repository.save(new TipodeBaja(null, "Venta", "Activo retirado por venta"));
            repository.save(new TipodeBaja(null, "Robo", "Activo retirado por robo"));
            repository.save(new TipodeBaja(null, "Roto", "Activo retirado por daño o rotura"));
            repository.save(new TipodeBaja(null, "Error", "Activo retirado por error administrativo"));
        }
    }
}

