package com.example.java5n_sd19306.entity;

import jakarta.persistence.*;

@NamedQuery( //JPQL
        name = "Student.findByNameV4a",
        query = "SELECT s FROM Student s WHERE s.name=?1"
)
@NamedNativeQuery(
        name = "Student.findByNameV4b",
        query = "SELECT * FROM students s WHERE s.name=?1",
        resultClass = Student.class
)
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

