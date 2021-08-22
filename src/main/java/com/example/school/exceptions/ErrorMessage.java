package com.example.school.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ErrorMessage {
    
    private String title;
    private String mesage;
    private LocalDate date;
    private Integer status;

    public ErrorMessage(Exception e, HttpStatus status){
        this.title = e.getClass().getName();
        this.mesage = e.getMessage();
        this.date  = LocalDate.now();
        this.status = status.value();
    }
}
