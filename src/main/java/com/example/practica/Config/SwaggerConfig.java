package com.example.practica.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("VSIAF API - Grupo 4")
                        .version("1.0.0")
                        .description(
                                """
                                        Sistema CRUD desarrollado en Spring Boot y PostgreSQL para la gestión del sistema VSIAF.

                                        Integrantes del Grupo 4:
                                        Jhamel Javier Pinto Ubaldes · Florencia Magali Alanoca Condori · Paola Lizeth Gutierrez Ckacka · Mario Gustavo Sanhueza Condori · Elva Alvarado Geronimo · Sebastián Alvaro Anze Colque · Saul Cusipuma Marino

                                        Materia: Tecnologías Emergentes | Gestión: 2026
                                        """));
    }
}