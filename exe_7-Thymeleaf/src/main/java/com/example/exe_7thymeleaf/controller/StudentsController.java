package com.example.exe_7thymeleaf.controller;


import com.example.exe_7thymeleaf.dao.StudentRepository;
import com.example.exe_7thymeleaf.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
@Slf4j
public class StudentsController {

    private final StudentRepository studentRepository;

    public StudentsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping({"/","/list"})
    public ModelAndView getAllStudent(){
        log.info("/list -> connection");
        ModelAndView nav = new ModelAndView("/list_students");
        nav.addObject("students",studentRepository.findAll());
        return nav;
    }
    @GetMapping("/addStudentForm")
    public ModelAndView addStudentForm(){
        ModelAndView nav = new ModelAndView("/add-student-form");
        Student student = new Student();
        nav.addObject("student", student);
        return nav;
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/list";
    }


    @GetMapping("showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Integer studentId){
        ModelAndView nav = new ModelAndView("/add-student-form");
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = new Student();
        if (optionalStudent.isPresent()){
            student = optionalStudent.get();
        }
        nav.addObject("student",student);
        return nav;
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Integer studentId){
        studentRepository.deleteById(studentId);
        return "redirect:/list";
    }
}
