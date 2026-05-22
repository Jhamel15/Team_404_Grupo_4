package com.example.practica.services;

import com.example.practica.entity.ClaDept;
import com.example.practica.repository.ClaDeptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaDeptService {

    private final ClaDeptRepository claDeptRepository;

    public ClaDeptService(ClaDeptRepository claDeptRepository) {
        this.claDeptRepository = claDeptRepository;
    }

    public List<ClaDept> obtenerTodos() {
        return claDeptRepository.findAll();
    }

    public ClaDept guardar(ClaDept depto) {
        return claDeptRepository.save(depto);
    }

    public ClaDept actualizar(Long id, ClaDept deptoActualizado) {
        return claDeptRepository.findById(id).map(depto -> {
            depto.setCodigo(deptoActualizado.getCodigo());
            depto.setNombre(deptoActualizado.getNombre());
            depto.setSigla(deptoActualizado.getSigla());
            return claDeptRepository.save(depto);
        }).orElse(null);
    }

    public String eliminar(Long id) {
        if (claDeptRepository.existsById(id)) {
            claDeptRepository.deleteById(id);
            return "Departamento eliminado";
        }
        return "No se encontró el departamento";
    }
}