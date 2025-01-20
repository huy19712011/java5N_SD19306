package com.example.java5n_sd19306.repository;

import com.example.java5n_sd19306.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepositoryV2 extends JpaRepository<Student, Long> {

    // all methods
    // 1. Built-in methods
    // extends JpaRepository => ListPagingAndSortingRepository => PagingAndSortingRepository =>
    // CrudRepository

    // 2. Ghep ten cac truong => methods
    // read...By, get...By, query...By, find...By
    // First, Top: FindFirst2ByName, findTop10ByName
    // Distinct: findDistinctByName
    // AND, OR: findByNameOrDescription, findByNameAndPrice
    // example: like/containing
    List<Student> findByNameContaining(String name);


    // 3. JPQL/ Native query with named parameters
    // using index params
    @Query("SELECT s FROM Student s WHERE s.name=?1 OR s.id=?2")
    List<Student> findByNameOrIdV3a(String name, long id);

    // using named params
    @Query(value = "SELECT * FROM students s WHERE s.name=:name OR s.id=:id", nativeQuery = true)
    List<Student> findByNameOrIdV3b(String name, long id);

    // 4. Named queries
    // JPQL
    List<Student> findByNameV4a(String name);

    // Native
    @Query(nativeQuery = true)
    List<Student> findByNameV4b(String name);


}
