package com.example.webassessment.repository;

import com.example.webassessment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameIgnoreCase(String name);
}
