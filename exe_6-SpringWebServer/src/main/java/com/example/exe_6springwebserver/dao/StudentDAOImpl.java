package com.example.exe_6springwebserver.dao;

import com.example.exe_6springwebserver.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;
@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO{
    private final EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        Query query =  entityManager.createQuery("from Student");
        List<Student> allStudent = query.getResultList();
        log.info("getAllStudents:" + allStudent);
        return allStudent;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public void deleteStudent(int id) {
        Query query = entityManager.createQuery("delete from Student where id=:studentId");
        query.setParameter("studentId",id);
        query.executeUpdate();
    }
}
