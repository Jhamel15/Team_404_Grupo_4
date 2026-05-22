package com.example.practica.services;

import com.example.practica.entity.OrganismoFin;
import com.example.practica.repository.OrganismoFinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganismoFinService {

    private final OrganismoFinRepository repository;

    public OrganismoFinService(OrganismoFinRepository repository) {
        this.repository = repository;
    }

    public List<OrganismoFin> listarTodos() {
        return repository.findAll();
    }

    public Optional<OrganismoFin> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public OrganismoFin guardar(OrganismoFin organismoFin) {
        return repository.save(organismoFin);
    }

    public OrganismoFin actualizar(Long id, OrganismoFin datos) {

        OrganismoFin organismo = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Organismo financiero no encontrado"));

        organismo.setGestion(datos.getGestion());
        organismo.setCodigoOrganismo(datos.getCodigoOrganismo());
        organismo.setDescripcion(datos.getDescripcion());
        organismo.setSigla(datos.getSigla());

        return repository.save(organismo);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}