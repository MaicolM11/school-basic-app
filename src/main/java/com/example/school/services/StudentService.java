package com.example.school.services;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Student;

public interface StudentService {
    
    Student createStudent(Student student);
    void appendModuleToStudent(Integer moduleId, Integer studentId);
    void cancelModuleToStudent(Integer moduleId, Integer studentId);
    
    Student getById(Integer id);
    List<Module> getModulesOfStudent(Integer studentId);
    List<Student> getAll();

}