package com.example.school.services.impl;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Student;
import com.example.school.repo.StudentRepo;
import com.example.school.services.ModuleService;
import com.example.school.services.StudentService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {

    private final StudentRepo studentRepo;
    private final ModuleService moduleService;

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getById(Integer id) {   
        return studentRepo.findById(id)
                        .orElseThrow(()-> new IllegalStateException("Estudiante no encontrado"));
    }

    @Override
    public List<Module> getModulesOfStudent(Integer studentId) {
        Student studentFound = getById(studentId);
        return studentFound.getSubjects();
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    @Transactional
    public void appendModuleToStudent(Integer moduleId, Integer studentId) {
        Module moduleFound = moduleService.getById(moduleId);
        Student student = getById(studentId);
        if(!student.canRegisterModule())
            throw new IllegalStateException("El estudiante no puede registrar más modulos");    
        if(student.hasModule(moduleFound))
            throw new IllegalStateException("El estudiante ya tiene el modulo inscrito");    
        if(!moduleFound.isAvailable())
            throw new IllegalStateException("El modulo esta completo");
        student.getSubjects().add(moduleFound);
        moduleFound.incrementStudents();
    }

    @Override
    @Transactional
    public void cancelModuleToStudent(Integer moduleId, Integer studentId) {
        Module moduleFound = moduleService.getById(moduleId);
        Student student = getById(studentId);
        boolean removeIfExist = student.getSubjects().removeIf(x-> x.getId() == moduleFound.getId());
        if(!removeIfExist) throw new IllegalStateException("El estudiante no tiene ese modulo inscrita");
        moduleFound.decrementStudents();
    }
    
}