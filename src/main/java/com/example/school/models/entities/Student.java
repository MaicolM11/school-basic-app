package com.example.school.models.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private static final Integer MAX_MODULE = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    private LocalDate birthDate;
    private String career;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY) 
    @JoinTable( 
        name = "student_modules", 
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id")) 
    private List<Module> subjects;

    public boolean canRegisterModule() {
        return MAX_MODULE > subjects.size();
    }

    public boolean hasModule(Module module) {
        return subjects.stream()
                    .anyMatch(x-> x.getId() == module.getId());
    }

}