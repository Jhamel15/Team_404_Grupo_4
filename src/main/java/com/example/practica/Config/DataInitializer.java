package com.example.practica.Config;

import com.example.practica.entity.Estado;
import com.example.practica.entity.Mes;
import com.example.practica.entity.Oficina;
import com.example.practica.entity.Usuario;
import com.example.practica.repository.EstadoRepository;
import com.example.practica.repository.MesRepository;
import com.example.practica.repository.OficinaRepository;
import com.example.practica.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner cargarDatosIniciales(
            EstadoRepository estadoRepository,
            MesRepository mesRepository,
            OficinaRepository oficinaRepository,
            UsuarioRepository usuarioRepository) {

        return args -> {

            if (estadoRepository.count() == 0) {
                estadoRepository.save(new Estado(null, "Bueno"));
                estadoRepository.save(new Estado(null, "Regular"));
                estadoRepository.save(new Estado(null, "Malo"));
                estadoRepository.save(new Estado(null, "En mantenimiento"));
            }

            if (mesRepository.count() == 0) {
                mesRepository.save(new Mes(null, "Enero", 1));
                mesRepository.save(new Mes(null, "Febrero", 2));
                mesRepository.save(new Mes(null, "Marzo", 3));
                mesRepository.save(new Mes(null, "Abril", 4));
                mesRepository.save(new Mes(null, "Mayo", 5));
                mesRepository.save(new Mes(null, "Junio", 6));
                mesRepository.save(new Mes(null, "Julio", 7));
                mesRepository.save(new Mes(null, "Agosto", 8));
                mesRepository.save(new Mes(null, "Septiembre", 9));
                mesRepository.save(new Mes(null, "Octubre", 10));
                mesRepository.save(new Mes(null, "Noviembre", 11));
                mesRepository.save(new Mes(null, "Diciembre", 12));
            }

            if (oficinaRepository.count() == 0) {
                oficinaRepository.save(new Oficina(null, "Oficina Administrativa", "Área principal", "Activo"));
                oficinaRepository.save(new Oficina(null, "Área Financiera", "Control financiero", "Activo"));
                oficinaRepository.save(new Oficina(null, "Dirección General", "Gerencia institucional", "Activo"));
            }

            if (usuarioRepository.count() == 0) {
                usuarioRepository.save(new Usuario(null, "Juan Perez", "juan@gmail.com", "123456"));
                usuarioRepository.save(new Usuario(null, "Maria Lopez", "maria@gmail.com", "123456"));
                usuarioRepository.save(new Usuario(null, "Carlos Rojas", "carlos@gmail.com", "123456"));
            }
        };
    }
}
