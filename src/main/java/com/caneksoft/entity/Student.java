package com.caneksoft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_student")
    Long studentId;

    @Column(name= "first_name", nullable = false)
    String firstName;
    
    @Column(name= "last_name", nullable = false)
    String lastName;

    @Column(name= "email_student", unique=true, nullable = false)
    String email;   

}

// COMO CREAR UN CRUD #API con Spring Boot y MySQL en 40 Minutos
// by Chris Gámez Profe
// https://youtu.be/9XoaU5IMkRY?list=TLPQMTkwNzIwMjWnZheS2h9rMw
// time:38:29