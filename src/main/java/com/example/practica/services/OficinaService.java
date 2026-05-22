package com.example.practica.services;

import com.example.practica.entity.OficinaEntity;
import com.example.practica.repository.OficinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaService {

    private final OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public List<OficinaEntity> listar() {
        return oficinaRepository.findAll();
    }

    public OficinaEntity guardar(OficinaEntity oficina) {
        return oficinaRepository.save(oficina);
    }

    public OficinaEntity actualizar(Integer id, OficinaEntity datos) {

        OficinaEntity oficina =
                oficinaRepository.findById(id).orElse(null);

        if (oficina != null) {

            oficina.setEntidad(datos.getEntidad());
            oficina.setUnidad(datos.getUnidad());
            oficina.setNomofic(datos.getNomofic());
            oficina.setObserv(datos.getObserv());
            oficina.setFeult(datos.getFeult());
            oficina.setUsuar(datos.getUsuar());
            oficina.setApi_estado(datos.getApi_estado());

            return oficinaRepository.save(oficina);
        }

        return null;
    }

    public void eliminar(Integer id) {
        oficinaRepository.deleteById(id);
    }
}