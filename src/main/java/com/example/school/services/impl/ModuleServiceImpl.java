package com.example.school.services.impl;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Professor;
import com.example.school.models.entities.Student;
import com.example.school.repo.ModuleRepo;
import com.example.school.services.ModuleService;
import com.example.school.services.ProfessorService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepo moduleRepo;
    private final ProfessorService professorService;

    @Override
    public Module createModule(Module m, Integer professorId) {
        Professor professorFound = professorService.getById(professorId);
        m.setProfessor(professorFound);
        return moduleRepo.save(m);
    }

    @Override
    @Transactional
    public void changeModuleProfessor(Integer moduleId, Integer profesorId) {
        Module moduleFound = this.getById(moduleId);
        Professor professorFound = professorService.getById(profesorId);
        moduleFound.setProfessor(professorFound);
    }

    @Override
    public Module getById(Integer id) {
        return moduleRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("El modulo no existe"));
    }

    @Override
    public List<Student> getStudentsOfModule(Integer moduleId) {
        Module moduleFound = this.getById(moduleId);
        return moduleFound.getStudents();
    }

    @Override
    public Professor getProfessorOfModule(Integer moduleId) {
        Module moduleFound = this.getById(moduleId);
        return moduleFound.getProfessor();
    }

    @Override
    public List<Module> getAllModules() {
        return (List<Module>) moduleRepo.findAll();
    }
    
}