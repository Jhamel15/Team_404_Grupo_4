// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.practica.controller;

import com.example.practica.model.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
   private List<Usuario> listaUsuarios = new ArrayList();

   public UsuarioController() {
      this.listaUsuarios.add(new Usuario(1, "Juan Perez", "juan@gmail.com"));
      this.listaUsuarios.add(new Usuario(2, "Maria Lopez", "maria@gmail.com"));
      this.listaUsuarios.add(new Usuario(3, "Carlos Rojas", "carlos@gmail.com"));
   }

   @GetMapping
   public String obtenerUsuarios() {
      String datos = "";

      for(Iterator var2 = this.listaUsuarios.iterator(); var2.hasNext(); datos = datos + "-------------------------<br><br>") {
         Usuario usuario = (Usuario)var2.next();
         datos = datos + "ID: " + usuario.getId() + "<br>";
         datos = datos + "Nombre: " + usuario.getNombre() + "<br>";
         datos = datos + "Correo: " + usuario.getCorreo() + "<br>";
      }

      return datos;
   }

   @GetMapping({"/{id}"})
   public Usuario obtenerUsuarioPorId(@PathVariable int id) {
      Iterator var2 = this.listaUsuarios.iterator();

      Usuario usuario;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         usuario = (Usuario)var2.next();
      } while(usuario.getId() != id);

      return usuario;
   }

   @PostMapping
   public String agregarUsuario(@RequestBody Usuario usuario) {
      this.listaUsuarios.add(usuario);
      return "Usuario agregado correctamente";
   }

   @PutMapping({"/{id}"})
   public String actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado) {
      Iterator var3 = this.listaUsuarios.iterator();

      Usuario usuario;
      do {
         if (!var3.hasNext()) {
            return "Usuario no encontrado";
         }

         usuario = (Usuario)var3.next();
      } while(usuario.getId() != id);

      usuario.setNombre(usuarioActualizado.getNombre());
      usuario.setCorreo(usuarioActualizado.getCorreo());
      return "Usuario actualizado correctamente";
   }

   @DeleteMapping({"/{id}"})
   public String eliminarUsuario(@PathVariable int id) {
      Iterator var2 = this.listaUsuarios.iterator();

      Usuario usuario;
      do {
         if (!var2.hasNext()) {
            return "Usuario no encontrado";
         }

         usuario = (Usuario)var2.next();
      } while(usuario.getId() != id);

      this.listaUsuarios.remove(usuario);
      return "Usuario eliminado correctamente";
   }
}
