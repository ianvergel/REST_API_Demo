package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;
import com.spring.spring_rest.entity.Student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/students")
public class StudentRestController {
    
    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudents(@RequestBody StudentDto theStudentDto) {
        StudentDto saved = studentService.createStudent(theStudentDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
