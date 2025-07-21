package com.caneksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caneksoft.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    // No additional methods are needed for basic CRUD operations
    // JpaRepository provides methods like save, findById, findAll, deleteById, etc.
}
