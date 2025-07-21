package com.caneksoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.caneksoft.entity.Student;
import com.caneksoft.service.impl.StudentServiceImpl;


@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    
    @Autowired
    private StudentServiceImpl serviceService;

    @CrossOrigin
    @GetMapping
    public List<Student>getStudents() {
        return serviceService.getAllStudents();
    }

    @CrossOrigin    
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return serviceService.getStudentById(id);   
    }    

    @CrossOrigin
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return serviceService.createStudent(student);  
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return serviceService.updateStudent(id, student);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        serviceService.deleteStudent(id);
    }
    
    // @PostMapping
    // public void saveOrUpdateStudent(Student student) {
    //     serviceService.saveOrUpdateStudent(student);
    // }

    @GetMapping("/count_students")
    public long countStudents() {
        return serviceService.countStudents();
    }


}
