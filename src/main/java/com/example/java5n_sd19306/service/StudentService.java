package com.example.java5n_sd19306.service;

import com.example.java5n_sd19306.entity.Student;
import com.example.java5n_sd19306.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {

        return studentRepository.getAllStudents();
    }
}
