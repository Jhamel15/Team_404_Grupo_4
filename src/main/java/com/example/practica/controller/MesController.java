package com.example.practica.controller;

import com.example.practica.Entity.Mes;
import com.example.practica.services.MesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meses")
public class MesController {

    private final MesService mesService;

    public MesController(MesService mesService) {
        this.mesService = mesService;

        if (mesService.listar().isEmpty()) {
            mesService.guardar(new Mes(null, "Enero", 1));
            mesService.guardar(new Mes(null, "Febrero", 2));
            mesService.guardar(new Mes(null, "Marzo", 3));
            mesService.guardar(new Mes(null, "Abril", 4));
            mesService.guardar(new Mes(null, "Mayo", 5));
            mesService.guardar(new Mes(null, "Junio", 6));
            mesService.guardar(new Mes(null, "Julio", 7));
            mesService.guardar(new Mes(null, "Agosto", 8));
            mesService.guardar(new Mes(null, "Septiembre", 9));
            mesService.guardar(new Mes(null, "Octubre", 10));
            mesService.guardar(new Mes(null, "Noviembre", 11));
            mesService.guardar(new Mes(null, "Diciembre", 12));
        }
    }

    @GetMapping
    public List<Mes> obtenerMeses() {
        return mesService.listar();
    }

    @GetMapping("/{id}")
    public Mes obtenerMesPorId(@PathVariable Integer id) {
        return mesService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Mes agregarMes(@RequestBody Mes mes) {
        return mesService.guardar(mes);
    }

    @PutMapping("/{id}")
    public Mes actualizarMes(@PathVariable Integer id, @RequestBody Mes mesActualizado) {
        return mesService.actualizar(id, mesActualizado);
    }

    @DeleteMapping("/{id}")
    public String eliminarMes(@PathVariable Integer id) {
        mesService.eliminar(id);
        return "Mes eliminado correctamente";
    }
}