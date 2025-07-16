package com.caneksoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String ubicacion;
    private String position;
    private String fullname;
    private String image;
    @Column(name = "usuario")
    private String user;
    private String password;

    public Persona(Long id, String ubicacion, String position, String fullname, String image, String user,
            String password) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.position = position;
        this.fullname = fullname;
        this.image = image;
        this.user = user;
        this.password = password;
    }
}
