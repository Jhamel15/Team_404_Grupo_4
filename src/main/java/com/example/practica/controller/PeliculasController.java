package com.example.practica.controller;

import com.example.practica.model.Pelicula;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PeliculasController {

        private final List<Pelicula> listaPeliculas = new ArrayList<>(Arrays.asList(
                        new Pelicula(1L, "Barbie", "Greta Gerwig", 2023, 114, "Comedia",
                                        "Barbie descubre el mundo real y su identidad."),
                        new Pelicula(2L, "Five Nights at Freddy's", "Emma Tammi", 2023, 110, "Terror",
                                        "Un guardia enfrenta animatronicos peligrosos."),
                        new Pelicula(3L, "Avengers: Age of Ultron", "Joss Whedon", 2015, 141, "Accion",
                                        "Los Vengadores luchan contra Ultron."),
                        new Pelicula(4L, "Spider-Man: No Way Home", "Jon Watts", 2021, 148, "Accion",
                                        "El multiverso se abre y aparecen enemigos."),
                        new Pelicula(5L, "Scream 6", "Matt Bettinelli", 2023, 123, "Terror",
                                        "Un nuevo Ghostface en Nueva York.")));

        private Long siguienteId = 6L;

        // ✅ GET TODOS + FILTROS
        @GetMapping("/peliculas")
        public ResponseEntity<List<Pelicula>> obtenerPeliculas(
                        @RequestParam(name = "anio", required = false) Integer anio,
                        @RequestParam(name = "genero", required = false) String genero) {

                List<Pelicula> resultado = listaPeliculas.stream()
                                .filter(p -> anio == null || p.getAnio() == anio)
                                .filter(p -> genero == null || p.getGenero().equalsIgnoreCase(genero))
                                .collect(Collectors.toList());

                return ResponseEntity.ok(resultado);
        }

        // ✅ GET POR ID (ARREGLADO PARA SWAGGER)
        @GetMapping("/peliculas/{id}")
        public ResponseEntity<?> obtenerPeliculaPorId(@PathVariable("id") Long id) {

                Optional<Pelicula> pelicula = listaPeliculas.stream()
                                .filter(p -> p.getId().equals(id))
                                .findFirst();

                if (pelicula.isPresent()) {
                        return ResponseEntity.ok(pelicula.get());
                }

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("Pelicula no encontrada con id: " + id);
        }

        // ✅ POST
        @PostMapping("/peliculas")
        public ResponseEntity<Pelicula> agregarPelicula(@RequestBody Pelicula nueva) {

                nueva.setId(siguienteId++);
                listaPeliculas.add(nueva);

                return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
        }

        // ✅ PUT (ARREGLADO)
        @PutMapping("/peliculas/{id}")
        public ResponseEntity<?> actualizarPelicula(
                        @PathVariable("id") Long id,
                        @RequestBody Pelicula datos) {

                Optional<Pelicula> pelicula = listaPeliculas.stream()
                                .filter(p -> p.getId().equals(id))
                                .findFirst();

                if (pelicula.isPresent()) {
                        Pelicula p = pelicula.get();

                        p.setTitulo(datos.getTitulo());
                        p.setDirector(datos.getDirector());
                        p.setAnio(datos.getAnio());
                        p.setDuracion(datos.getDuracion());
                        p.setGenero(datos.getGenero());
                        p.setSinopsis(datos.getSinopsis());

                        return ResponseEntity.ok(p);
                }

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("No se puede actualizar. No existe id: " + id);
        }

        // ✅ DELETE (ARREGLADO)
        @DeleteMapping("/peliculas/{id}")
        public ResponseEntity<String> eliminarPelicula(@PathVariable("id") Long id) {

                Optional<Pelicula> pelicula = listaPeliculas.stream()
                                .filter(p -> p.getId().equals(id))
                                .findFirst();

                if (pelicula.isPresent()) {
                        listaPeliculas.remove(pelicula.get());
                        return ResponseEntity.ok("Pelicula eliminada con id: " + id);
                }

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("No se puede eliminar. No existe id: " + id);
        }
}