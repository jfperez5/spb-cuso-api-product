package com.caneksoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caneksoft.entity.Message;

@RestController
@RequestMapping("api/messages")
public class MessageController {
      private List<Message> mensajes = new ArrayList<>();

    // public MessageController(List<Message> mensajes){
    //     this.mensajes = mensajes;
    // }

    // Constructor que agrega los mensajes iniciales
    public MessageController(){
        mensajes.add(new Message(1,"Suscríbete en La Tecnología Avanza"));
        mensajes.add(new Message(2,"Comparte el video en tus redes sociales"));
        mensajes.add(new Message(3,"Esta muy lento escribiendo codigo java, aplicate"));
        mensajes.add(new Message(5,"Concentrate para quitarte el sueño"));
    }

    // Método para obtener todos los mensajes
    @GetMapping
    public List<Message> listarMensajes(){
        return mensajes;
    }

    // Método para obtener por id el mensaje
    @GetMapping("/{id}")
    public Message obtenerMensajePorId(@PathVariable int id){
        Optional<Message> message = mensajes.stream()
        .filter(m -> m.getId() == id )
        .findFirst();
        return message.orElse(null);
    }

    //Método para agregar nuevos mensajes
    @PostMapping
    public Message crearMensaje(@RequestBody Message message){
        mensajes.add(message);
        return message;
    }

    //Método para eliminar mensajes
    @DeleteMapping
    public void eliminarMensajes(@PathVariable int id){
        mensajes.removeIf(m->m.getId()==id);
    }
    
}
