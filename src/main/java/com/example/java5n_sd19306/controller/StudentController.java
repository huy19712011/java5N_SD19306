package com.example.java5n_sd19306.controller;

import com.example.java5n_sd19306.entity.Student;
import com.example.java5n_sd19306.service.StudentService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {


        // get data from DB
        List<Student> students = studentService.getAllStudents();

        // add to Model
        model.addAttribute("students", students);

        // return view name
        return "views/students";
    }
}
