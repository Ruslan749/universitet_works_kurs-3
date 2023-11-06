package com.example.exe_7thymeleaf.dao;


import com.example.exe_7thymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
