package com.spring.spring_rest.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Service implementation for managing CRUD Implementations.
 */
@Service 
public class StudentServiceImplement implements StudentService {

    private StudentRepository studentRepo;

    //Constructs the service with the required student repository.
    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**
     * Creates and saves a new student.
     */
    @Override 
    public StudentDto createStudent(StudentDto thStudentDto) {
        Student theStudent = StudentMapper.mapToStudent(thStudentDto);
        Student saved = studentRepo.save(theStudent);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Retrieves a student by their ID and saves it.
     * @return the saved student
     */
    @Override 
    public StudentDto getStudentById(Long theId) {
        Student student = studentRepo.findById(theId).orElseThrow(
            () -> new StudentNotFoundException
            ("Student id " + theId + " not found!"));

        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * Retrieves all students from the database.
     *
     * @return a list of all students
     */
    @Override 
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student))
            .collect(Collectors.toList());
    }

    /**
     * Updates all details of an existing student.
     * @return the updated student data
     */
    @Override 
    public StudentDto updateStudent(Long theId, StudentDto theStudentDto) {
        Student student = studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException
        ("Student id " + theId + " not found!"));

        student.setFirstName(theStudentDto.getFirstName());
        student.setLastName(theStudentDto.getLastName());
        student.setEmail(theStudentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Partially updates an existing student using only non-null fields.
     * @return the updated student data
     */
    @Override 
    public StudentDto patchStudent(Long theId, StudentDto theStudentDto) {
        Student student = studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException
        ("Student id " + theId + " not found!"));

        if(theStudentDto.getFirstName() != null) {
            student.setFirstName(theStudentDto.getFirstName());
        }
        if(theStudentDto.getLastName() != null) {
            student.setLastName(theStudentDto.getLastName());
        }
        if(theStudentDto.getEmail() != null) {
            student.setEmail(theStudentDto.getEmail());
        }

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Deletes a student by their ID.
     * @param theId ID of the student to delete
     */
    @Override 
    public void deleteStudentById(Long theId) {
        studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException
        ("Student id " + theId + " not found!"));

        studentRepo.deleteById(theId);
    }
}
