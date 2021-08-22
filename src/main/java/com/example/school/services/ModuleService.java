package com.example.school.services;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Professor;
import com.example.school.models.entities.Student;

public interface ModuleService {
    
    Module createModule(Module module, Integer professorId);
    void changeModuleProfessor(Integer moduleId, Integer proffesorId);
    
    Module getById(Integer id);
    List<Student> getStudentsOfModule(Integer moduleId);
    List<Module> getAllModules();
    Professor getProfessorOfModule(Integer moduleId);

}
