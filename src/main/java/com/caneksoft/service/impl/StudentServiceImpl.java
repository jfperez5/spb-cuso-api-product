package com.caneksoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caneksoft.entity.Student;
import com.caneksoft.repository.StudentRepository;

@Service
public class StudentServiceImpl {

    @Autowired
    StudentRepository studentRepository;

    // Obtener todos los estudiantes
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Crear estudiante
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }  

    // Obtener estudiante por ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Actualizar estudiante
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id)
            .map(student -> {
                student.setFirstName(studentDetails.getFirstName());
                student.setLastName(studentDetails.getLastName());
                student.setEmail(studentDetails.getEmail());
                
                return studentRepository.save(student);
            })
            .orElse(null);
    }

    // Eliminar estudiante
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Guardar o actualizar estudiante
    // public void saveOrUpdateStudent(Student student) {
    //     studentRepository.save(student);
    // }

    // Contar estudiantes
    public long countStudents() {
        return studentRepository.count();
    }
    
    // Verificar si existe estudiante por ID
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

}
