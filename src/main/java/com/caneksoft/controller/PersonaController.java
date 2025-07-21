package com.caneksoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caneksoft.dto.PersonaDTO;
import com.caneksoft.entity.Persona;
import com.caneksoft.service.impl.PersonaServiceImpl;


@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @GetMapping
    @RequestMapping
    public List<Persona> listarPersonas(){
        return personaServiceImpl.listarPersonas();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Persona buscarPersonaPorId(@PathVariable Long id){
        return personaServiceImpl.buscarPersonaPorId(id);
    }

    @PostMapping
    @ResponseBody
    public  Persona crearPersona(@RequestBody Persona persona){
        return personaServiceImpl.crearPersona(persona);
    }

    @PutMapping
    public void modificarPersona(@RequestBody Persona persona){
        personaServiceImpl.modificarPersona(persona);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaServiceImpl.borrarPersona(id);
    }  

    @PostMapping("/login")
    public PersonaDTO login (@RequestBody Persona persona){
    return personaServiceImpl.login(persona.getUser(), persona.getPassword());
    }
}
