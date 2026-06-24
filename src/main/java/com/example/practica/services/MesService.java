package com.example.practica.services;

import com.example.practica.entity.Mes;
import com.example.practica.repository.MesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesService {

    private final MesRepository mesRepository;

    public MesService(MesRepository mesRepository) {
        this.mesRepository = mesRepository;
    }

    public List<Mes> listar() {
        return mesRepository.findAll();
    }

    public Optional<Mes> buscarPorId(Integer id) {
        return mesRepository.findById(id);
    }

    public Mes guardar(Mes mes) {
        return mesRepository.save(mes);
    }

    public Mes actualizar(Integer id, Mes datos) {
        Mes mes = mesRepository.findById(id).orElse(null);
        if (mes != null) {
            mes.setNommes(datos.getNommes());
            mes.setNumero(datos.getNumero());
            return mesRepository.save(mes);
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        if (!mesRepository.existsById(id)) {
            return false;
        }

        mesRepository.deleteById(id);
        return true;
    }
}