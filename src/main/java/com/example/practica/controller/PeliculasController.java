package com.example.practica.controller;

import com.example.practica.model.Pelicula;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PeliculasController {

    private final List<Pelicula> listaPeliculas = new ArrayList<>(Arrays.asList(
            new Pelicula("Barbie", "Greta Gerwig", 2023, 114, "Comedia",
                    "Barbie descubre el mundo real y su identidad."),
            new Pelicula("Five Nights at Freddy's", "Emma Tammi", 2023, 110, "Terror",
                    "Un guardia enfrenta animatrónicos peligrosos."),
            new Pelicula("Avengers: Age of Ultron", "Joss Whedon", 2015, 141, "Acción",
                    "Los Vengadores luchan contra Ultron."),
            new Pelicula("Spider-Man: No Way Home", "Jon Watts", 2021, 148, "Acción",
                    "El multiverso se abre y aparecen enemigos."),
            new Pelicula("Scream 6", "Matt Bettinelli", 2023, 123, "Terror", "Un nuevo Ghostface en Nueva York."),
            new Pelicula("Deadpool & Wolverine", "Shawn Levy", 2024, 130, "Acción", "Dos antihéroes se unen."),
            new Pelicula("Dune: Part Two", "Denis Villeneuve", 2024, 166, "Ciencia Ficción", "Paul cumple su destino."),
            new Pelicula("Oppenheimer", "Christopher Nolan", 2023, 180, "Drama", "Creación de la bomba atómica."),
            new Pelicula("The Batman", "Matt Reeves", 2022, 176, "Acción", "Batman enfrenta al Acertijo."),
            new Pelicula("Jurassic World Dominion", "Colin Trevorrow", 2022, 147, "Aventura",
                    "Humanos y dinosaurios conviven.")));

    @GetMapping("/peliculas")
    public List<Pelicula> obtenerPeliculas(
            @RequestParam(required = false) Integer año,
            @RequestParam(required = false) String genero) {
        return listaPeliculas.stream()
                .filter(p -> (año == null || p.getAño() == año))
                .filter(p -> (genero == null || p.getGenero().equalsIgnoreCase(genero)))
                .collect(Collectors.toList());
    }

    @PostMapping("/peliculas")
    public Pelicula agregarPelicula(@RequestBody Pelicula nuevaPelicula) {
        listaPeliculas.add(nuevaPelicula);
        return nuevaPelicula;
    }
}