package com.example.school.api;

import java.util.List;

import com.example.school.models.entities.Module;
import com.example.school.models.entities.Student;
import com.example.school.services.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/students")
@Tag(name = "Student")
public class StudentResource {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student p) {
        return studentService.createStudent(p);
    }

    @GetMapping("{id}/modules")
    public List<Module> getModulesOfStudent(@PathVariable("id") Integer studentId) {
        return studentService.getModulesOfStudent(studentId);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id") Integer studentId) {
        return studentService.getById(studentId);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAll();
    }

    @PutMapping("{id}/modules/append")
    public void appendModuleToStudent(@PathVariable("id") Integer studentId, @RequestParam("moduleId") Integer moduleId) {
        studentService.appendModuleToStudent(moduleId, studentId);
    }

    @PutMapping("{id}/modules/cancel")
    public void cancelModuleToStudent(@PathVariable("id") Integer studentId, @RequestParam("moduleId") Integer moduleId) {
        studentService.cancelModuleToStudent(moduleId, studentId);
    }

}