package com.example.school.models.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "modules")
@AllArgsConstructor
@NoArgsConstructor
public class Module {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer maxStudents;
    private Integer actualStudents = 0;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professor;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY) // name of atribute
    private List<Student> students;

    public boolean isAvailable(){
        return this.maxStudents > actualStudents;
    }

    public void incrementStudents(){
        this.actualStudents++;
    }

    public void decrementStudents(){
        this.actualStudents--;
    }


}
