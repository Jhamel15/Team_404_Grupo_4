package com.example.practica.services;

import com.example.practica.entity.TipodeBaja;
import com.example.practica.repository.TipodeBajaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipodeBajaService {

    private final TipodeBajaRepository repository;

    public TipodeBajaService(TipodeBajaRepository repository) {
        this.repository = repository;
    }

    public List<TipodeBaja> listarTodos() {
        return repository.findAll();
    }

    public Optional<TipodeBaja> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public TipodeBaja guardar(TipodeBaja tipoBaja) {
        return repository.save(tipoBaja);
    }

    public TipodeBaja actualizar(Long id, TipodeBaja datos) {
        TipodeBaja tipo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        tipo.setNombre(datos.getNombre());
        tipo.setDescripcion(datos.getDescripcion());

        return repository.save(tipo);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}