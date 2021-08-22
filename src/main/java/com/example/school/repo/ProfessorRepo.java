package com.example.school.repo;

import com.example.school.models.entities.Professor;

import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepo extends CrudRepository <Professor, Integer> {
    
}
