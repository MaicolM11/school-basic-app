package com.example.school.repo;

import com.example.school.models.entities.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    
}
