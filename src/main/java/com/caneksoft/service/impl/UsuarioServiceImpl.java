package com.caneksoft.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caneksoft.entity.Usuario;
import com.caneksoft.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<Usuario> getUsuario(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public ArrayList<Usuario> getByPrioridadUsuario(int prioridad){
         return (ArrayList<Usuario>) usuarioRepository.findByPrioridad(prioridad);
    } 

    public Optional<Usuario> getById(Long id){
        return usuarioRepository.findById(id);
    }

    public boolean deleteUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    
}
