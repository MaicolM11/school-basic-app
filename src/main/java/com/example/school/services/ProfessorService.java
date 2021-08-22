package com.example.school.services;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Professor;

public interface ProfessorService {
    
    Professor createProfessor(Professor p);
    Professor getById(Integer id);
    List<Module> getListOfModules(Integer professorId);
    List<Professor> getAll();

}
