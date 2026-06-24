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

    public Estado buscarPorId(Integer id) {
        return estadoRepository.findById(id).orElse(null);
    }

    public Estado guardar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado actualizar(Integer id, Estado datos) {
        Estado estado = estadoRepository.findById(id).orElse(null);

        if (estado == null) {
            return null;
        }

        estado.setNomestado(datos.getNomestado());
        return estadoRepository.save(estado);
    }

    public boolean eliminar(Integer id) {
        if (!estadoRepository.existsById(id)) {
            return false;
        }

        estadoRepository.deleteById(id);
        return true;
    }
}
