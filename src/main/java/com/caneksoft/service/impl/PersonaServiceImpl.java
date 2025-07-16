package com.caneksoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caneksoft.dto.PersonaDTO;
import com.caneksoft.entity.Persona;
import com.caneksoft.repository.PersonaRepository;

@Service
public class PersonaServiceImpl {
    @Autowired
    PersonaRepository personaRepo;
    
    public Persona crearPersona(Persona persona){
        return (Persona) personaRepo.save(persona);
    }

    public void borrarPersona(Long id){
        personaRepo.deleteById(id);
    }

    public List<Persona>listarPersonas(){
        return personaRepo.findAll();
    }

    public Persona buscarPersonaPorId(Long id){
        return (Persona) personaRepo.findById(id).orElse(null);
    }

    public void modificarPersona(Persona persona){
        personaRepo.save(persona);
    }

    //ya teniendo el Repo se crea el servicio y el dto de persona hacemos el metodo.
    public PersonaDTO login (String user, String password){
        Persona persona = personaRepo.findByUserAndPassword(user, password);
        PersonaDTO personaDTO = new PersonaDTO(persona.getId(), persona.getUbicacion(), persona.getPosition(), persona.getFullname(),persona.getImage());
        return personaDTO;
    }
}
