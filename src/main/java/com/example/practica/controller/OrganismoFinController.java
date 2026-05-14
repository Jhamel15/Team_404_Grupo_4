package com.example.practica.controller;

import com.example.practica.model.OrganismoFin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/organismos")
public class OrganismoFinController {

    private List<OrganismoFin> organismos = new ArrayList<>();

    public OrganismoFinController() {
        organismos.add(new OrganismoFin(2026, 1, "Tesoro General de la Nación", "TGN"));
        organismos.add(new OrganismoFin(2026, 2, "Donación", "DON"));
        organismos.add(new OrganismoFin(2026, 3, "Recursos propios", "RP"));
    }

    @GetMapping
    public List<OrganismoFin> listarOrganismos() {
        return organismos;
    }

    @GetMapping("/{codigoOrganismo}")
    public OrganismoFin obtenerOrganismo(@PathVariable int codigoOrganismo) {
        for (OrganismoFin organismo : organismos) {
            if (organismo.getCodigoOrganismo() == codigoOrganismo) {
                return organismo;
            }
        }
        return null;
    }

    @PostMapping
    public OrganismoFin crearOrganismo(@RequestBody OrganismoFin nuevoOrganismo) {
        organismos.add(nuevoOrganismo);
        return nuevoOrganismo;
    }

    @PutMapping("/{codigoOrganismo}")
    public OrganismoFin editarOrganismo(
            @PathVariable int codigoOrganismo,
            @RequestBody OrganismoFin organismoEditado) {

        for (OrganismoFin organismo : organismos) {
            if (organismo.getCodigoOrganismo() == codigoOrganismo) {

                organismo.setGestion(organismoEditado.getGestion());
                organismo.setCodigoOrganismo(organismoEditado.getCodigoOrganismo());
                organismo.setDescripcion(organismoEditado.getDescripcion());
                organismo.setSigla(organismoEditado.getSigla());

                return organismo;
            }
        }

        return null;
    }

    @DeleteMapping("/{codigoOrganismo}")
    public String eliminarOrganismo(@PathVariable int codigoOrganismo) {

        for (OrganismoFin organismo : organismos) {
            if (organismo.getCodigoOrganismo() == codigoOrganismo) {
                organismos.remove(organismo);
                return "Organismo financiador eliminado correctamente";
            }
        }

        return "Organismo financiador no encontrado";
    }
}