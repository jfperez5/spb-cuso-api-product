package com.caneksoft.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.caneksoft.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public abstract ArrayList<Usuario> findByPrioridad(Integer prioridad);
}
