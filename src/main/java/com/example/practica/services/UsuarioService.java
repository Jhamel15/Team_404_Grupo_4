package com.example.practica.services;

import com.example.practica.entity.Usuario;
import com.example.practica.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Integer id, Usuario datos) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null;
        }

        usuario.setNombre(datos.getNombre());
        usuario.setCorreo(datos.getCorreo());
        usuario.setPassword(datos.getPassword());

        return usuarioRepository.save(usuario);
    }

    public boolean eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }
}
