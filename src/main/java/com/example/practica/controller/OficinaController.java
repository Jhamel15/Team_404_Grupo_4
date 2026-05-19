package com.example.practica.controller;

import com.example.practica.model.Oficina;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    private List<Oficina> listaOficinas = new ArrayList<>();

    public OficinaController() {
        listaOficinas.add(new Oficina(1, "Oficina Administrativa", "Área principal"));
        listaOficinas.add(new Oficina(2, "Área Financiera", "Control financiero"));
        listaOficinas.add(new Oficina(3, "Dirección General", "Gerencia general"));
    }

    @GetMapping
    public List<Oficina> obtenerOficinas() {
        return listaOficinas;
    }

    // POST - agregar oficina
    @PostMapping
    public Oficina agregarOficina(@RequestBody Oficina oficina) {
        listaOficinas.add(oficina);
        return oficina;
    }

    @PutMapping("/{codigo}")
    public Oficina actualizarOficina(@PathVariable int codigo,
            @RequestBody Oficina oficinaActualizada) {

        for (Oficina oficina : listaOficinas) {

            if (oficina.getCodigo() == codigo) {

                oficina.setNombre(oficinaActualizada.getNombre());
                oficina.setObservaciones(oficinaActualizada.getObservaciones());

                return oficina;
            }
        }

        return null;
    }

    @DeleteMapping("/{codigo}")
    public String eliminarOficina(@PathVariable int codigo) {

        listaOficinas.removeIf(oficina -> oficina.getCodigo() == codigo);

        return "Oficina eliminada correctamente";
    }
}