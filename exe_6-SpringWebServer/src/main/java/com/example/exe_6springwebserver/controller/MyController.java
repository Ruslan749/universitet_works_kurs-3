package com.example.exe_6springwebserver.controller;

import com.example.exe_6springwebserver.entity.Student;
import com.example.exe_6springwebserver.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class MyController {
   private final StudentService studentService;
    @Autowired
    public MyController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> showAllStudents(){
        List<Student> allStudents = studentService.getAllStudent();
        return allStudents;
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody @Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("не правильный запрос на добавление данных");
            return null;
        }
        log.info("студент успешно добавлен");
        return studentService.saveStudent(student);
    }

    @PutMapping("students/{id}")
    public Student updeteStudent(@RequestBody @Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("не правильный запрос на добавление данных");
            return null;
        }
        log.info("студент успешно добавлен");
        return studentService.saveStudent(student);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }
}
