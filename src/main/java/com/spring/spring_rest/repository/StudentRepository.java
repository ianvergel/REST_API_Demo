package com.spring.spring_rest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.spring_rest.entity.Student;

/**
 * A child class that inherits the existing CRUD methods in JpaRepository
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
