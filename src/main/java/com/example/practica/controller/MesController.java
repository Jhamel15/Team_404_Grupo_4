package com.example.practica.controller;

import com.example.practica.model.Mes;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meses")
public class MesController {

    private List<Mes> listaMeses = new ArrayList<>();

    public MesController() {

        listaMeses.add(new Mes(1L, "Enero", 1));
        listaMeses.add(new Mes(2L, "Febrero", 2));
        listaMeses.add(new Mes(3L, "Marzo", 3));
        listaMeses.add(new Mes(4L, "Abril", 4));
        listaMeses.add(new Mes(5L, "Mayo", 5));
        listaMeses.add(new Mes(6L, "Junio", 6));
        listaMeses.add(new Mes(7L, "Julio", 7));
        listaMeses.add(new Mes(8L, "Agosto", 8));
        listaMeses.add(new Mes(9L, "Septiembre", 9));
        listaMeses.add(new Mes(10L, "Octubre", 10));
        listaMeses.add(new Mes(11L, "Noviembre", 11));
        listaMeses.add(new Mes(12L, "Diciembre", 12));
    }

    @GetMapping
    public List<Mes> obtenerMeses() {
        return listaMeses;
    }

    @GetMapping("/{id}")
    public Mes obtenerMesPorId(@PathVariable Long id) {

        for (Mes mes : listaMeses) {

            if (mes.getId().equals(id)) {
                return mes;
            }
        }

        return null;
    }

    @PostMapping
    public Mes agregarMes(@RequestBody Mes mes) {

        listaMeses.add(mes);

        return mes;
    }

    @PutMapping("/{id}")
    public Mes actualizarMes(@PathVariable Long id,
                             @RequestBody Mes mesActualizado) {

        for (Mes mes : listaMeses) {

            if (mes.getId().equals(id)) {

                mes.setNombre(mesActualizado.getNombre());
                mes.setNumero(mesActualizado.getNumero());

                return mes;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminarMes(@PathVariable Long id) {

        listaMeses.removeIf(mes -> mes.getId().equals(id));

        return "Mes eliminado correctamente";
    }
}