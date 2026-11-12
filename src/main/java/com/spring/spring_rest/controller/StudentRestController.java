package com.spring.spring_rest.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * REST controller for handling HTTP requests related to student management.
 */
@RestController 
@RequestMapping("/api/students")
public class StudentRestController {
    private StudentService studentService;
    
    //Constructor for studentService
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Creates a new student record.
     */
    @PostMapping 
    public ResponseEntity<StudentDto>createStudents
    (@Valid @RequestBody StudentDto theStudentDto) {
        StudentDto saved = studentService.createStudent(theStudentDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Retrieves a student by their ID.
     */
    @GetMapping("{id}")
    public ResponseEntity<StudentDto>getStudentById(@PathVariable Long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Retrieves list of all the students.
     */
    @GetMapping 
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * Fully updates an existing student record.
     */
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent
    (@PathVariable Long id, @Valid @RequestBody StudentDto theStudentDto) {
        StudentDto studentDto = studentService.updateStudent
        (id, theStudentDto);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Updates a specific column of an existing student record.
     */
    @PatchMapping("{id}")
    public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id,
        @Valid @RequestBody StudentDto theStudentDto) {
            StudentDto studentDto = studentService.patchStudent
            (id, theStudentDto);
            return ResponseEntity.ok(studentDto);
    }

    /**
     * Deletes a student by their ID.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
