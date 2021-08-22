package com.example.school.presentation;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Professor;
import com.example.school.services.ProfessorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/professors")
@RequiredArgsConstructor
public class ProfessorResource {
    
    private final ProfessorService professorService;

    @PostMapping
    public Professor createProfessor(@RequestBody Professor p){
        return professorService.createProfessor(p);
    }

    @GetMapping("{id}/modules")
    public List<Module> getModulesOfProfessor(@PathVariable("id") Integer professorId) {
        return professorService.getListOfModules(professorId);
    }

    @GetMapping("{id}")
    public Professor getProfessorById(@PathVariable("id") Integer professorId) {
        return professorService.getById(professorId);
    }

    @GetMapping
    public List<Professor> getAll() {
        return professorService.getAll();
    }

}