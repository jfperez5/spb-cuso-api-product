package com.caneksoft.repository;

import com.caneksoft.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Optional<Categoria> findByNombreCategoria(String nombreCategoria);

    boolean existsByNombreCategoria(String nombreCategoria);

}