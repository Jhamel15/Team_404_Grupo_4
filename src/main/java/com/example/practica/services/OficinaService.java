package com.example.practica.services;

import com.example.practica.entity.Oficina;
import com.example.practica.repository.OficinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaService {

    private final OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public List<Oficina> listar() {
        return oficinaRepository.findAll();
    }

    public Oficina buscarPorId(Integer id) {
        return oficinaRepository.findById(id).orElse(null);
    }

    public Oficina guardar(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    public Oficina actualizar(Integer id, Oficina datos) {

        Oficina oficina = oficinaRepository.findById(id).orElse(null);

        if (oficina != null) {

            oficina.setNombre(datos.getNombre());
            oficina.setDescripcion(datos.getDescripcion());
            oficina.setEstado(datos.getEstado());

            return oficinaRepository.save(oficina);
        }

        return null;
    }

    public boolean eliminar(Integer id) {
        if (!oficinaRepository.existsById(id)) {
            return false;
        }

        oficinaRepository.deleteById(id);
        return true;
    }
}