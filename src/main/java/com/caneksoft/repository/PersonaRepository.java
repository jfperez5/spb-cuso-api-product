package com.caneksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caneksoft.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    public Persona findByUserAndPassword(String user, String password);
}
