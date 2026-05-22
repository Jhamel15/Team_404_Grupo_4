package com.example.practica.services;

import com.example.practica.entity.Estado;
import com.example.practica.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    public Estado guardar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado actualizar(Integer id, Estado datos) {
        Estado estado = estadoRepository.findById(id).orElse(null);

        if (estado != null) {
            estado.setNomestado(datos.getNomestado());
            return estadoRepository.save(estado);
        }

        return null;
    }

    public void eliminar(Integer id) {
        estadoRepository.deleteById(id);
    }
}