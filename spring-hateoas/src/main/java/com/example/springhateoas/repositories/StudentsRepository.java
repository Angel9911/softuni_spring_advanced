package com.example.springhateoas.repositories;

import com.example.springhateoas.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Student,Long> {
}
