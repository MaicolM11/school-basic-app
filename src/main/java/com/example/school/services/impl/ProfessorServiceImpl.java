package com.example.school.services.impl;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Professor;
import com.example.school.repo.ProfessorRepo;
import com.example.school.services.ProfessorService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepo professorRepo;

    @Override
    public Professor createProfessor(Professor p) {
        return professorRepo.save(p);
    }

    @Override
    public Professor getById(Integer id) {
        return professorRepo.findById(id)
                    .orElseThrow(()-> new IllegalStateException("Profesor no existe"));
    }

    @Override
    public List<Module> getListOfModules(Integer professorId) {
        Professor professorFound = getById(professorId);
        return professorFound.getModules();
    }

    @Override
    public List<Professor> getAll() {
        return (List<Professor>) professorRepo.findAll();
    }    
    
}