package com.example.school.presentation;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Professor;
import com.example.school.models.entities.Student;
import com.example.school.services.ModuleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/modules")
@RequiredArgsConstructor
public class ModuleResource {
    
    private final ModuleService moduleService;

    @PostMapping
    public Module createdModule(@RequestBody Module module, @RequestParam("professorId") Integer professorId) {
        return moduleService.createModule(module, professorId);
    }

    @GetMapping("{id}/professor")
    public Professor getProfessorOfModule(@PathVariable("id") Integer moduleId){
        return moduleService.getProfessorOfModule(moduleId);
    }

    @GetMapping("{id}/students")
    public List<Student> getStudentsOfModule(@PathVariable("id") Integer moduleId){
        return moduleService.getStudentsOfModule(moduleId);
    }

    @GetMapping("{id}")
    public Module getModuleById(@PathVariable("id") Integer moduleId){
        return moduleService.getById(moduleId);
    }

    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

}