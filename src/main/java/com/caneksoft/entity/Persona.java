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

// Nota: Spring boot + API REST + JPA + QUERY METHOD +DTO
// by Ivana Soledad Rojas Córsico

/* 
 *  Nota: Cunado se quieren hacer una busqueda compleja o un metodo que no este en los básicos de JPA, se útilizan los Query Methods.
 * Spring Boot - Query Methods
 * Los query methods de JPa Spring Boot nos proveen la posibilidad de generar consultas mediante el nombre de los métodos teniendo encuenta algunas reglas:
 * El nombre de la consulta debe comenzar con una palabra reservada. Ejemplo: find
 * Tal como en la query sql, los atributos deben estar conectados con palabras clave según se requiera Ej: By, And, Or,etc.
 *  Ejemplo: 
 * //Where user=? and pwd=?
 * Boolean findByUserAndPwd(String user, String pwd)
 * //Where idPersona = ?
 * List<Experiencia> findByIdPersona(Long idPersona);
 * //Where lastName like ?% And id < ? 
 * List<Person>getByLastNameStartingWhithAndIdLessThan(String lastName Integer id)
 * 
 * Para más información se puede consultar el siguiente link: https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html
*/