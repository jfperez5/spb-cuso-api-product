package com.caneksoft.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caneksoft.entity.Usuario;
import com.caneksoft.service.impl.UsuarioServiceImpl;



@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @CrossOrigin
    @GetMapping()
    public ArrayList<Usuario> getUsuarios(){
        return usuarioService.getUsuario();
    }

    @CrossOrigin
    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.saveUsuario(usuario);
    }

    @CrossOrigin
    @GetMapping("/query")
    public ArrayList<Usuario> getUsuarios(@RequestParam("prioridad")  Integer prioridad){
        return usuarioService.getByPrioridadUsuario(prioridad);
    }

    //  @GetMapping("/{id}") así tambien funciona
    @CrossOrigin
    @GetMapping(path ="/{id}") 
    public Optional<Usuario>getByIdUsuario(@PathVariable Long id){
        return this.usuarioService.getById(id);
    }  

    @CrossOrigin
    @DeleteMapping("/{id}")
    public String deleteByIdUsuario(@PathVariable("id") Long id ){
        boolean ok = this.usuarioService.deleteUsuario(id);
        if(ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id " + id;
        }
    }    
}
