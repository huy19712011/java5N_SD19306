package com.example.java5n_sd19306;

import com.example.java5n_sd19306.entity.Student;
import com.example.java5n_sd19306.repository.StudentRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Java5NSd19306Application implements CommandLineRunner {

    private final StudentRepositoryV2 studentRepositoryV2;

    public Java5NSd19306Application(StudentRepositoryV2 studentRepositoryV2) {
        this.studentRepositoryV2 = studentRepositoryV2;
    }

    public static void main(String[] args) {
        SpringApplication.run(Java5NSd19306Application.class, args);

        System.out.println("running...");
    }

    @Override
    public void run(String... args) throws Exception {

        // 2. example
        studentRepositoryV2
                .findByNameContaining("student")
                .forEach(s -> System.out.println(s.getName()));

        // 3.
        studentRepositoryV2
                .findByNameOrIdV3b("student 1", 1004)
                .forEach(s -> System.out.println(s.getName()));

        // 4.
        studentRepositoryV2
                .findByNameV4b("student 1")
                .forEach(s -> System.out.println(s.getName()));

        // 5. Pagination
        int pageNo = 0; // index = 0 by default
        int pageSize = 2;

        // creating pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // get all info via Page
        Page<Student> page = studentRepositoryV2.findAll(pageable);

        // all items
        List<Student> students = page.getContent();
        students.forEach(s -> System.out.println(s.getName()));

        // total pages
        int totalPages = page.getTotalPages();
        System.out.println(totalPages);

        // total elements
        long totalElements = page.getTotalElements();
        System.out.println(totalElements);

        // size, last, first, ...

        // 6. Sorting
        String sortBy = "name";
        String sortDir = "desc"; // "asc"

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy) : Sort.by(sortBy).descending();

        studentRepositoryV2
                .findAll(sort)
                .forEach(s -> System.out.println(s.getName()));

        // multiple fields
        Sort.by("name").descending()
                .and(Sort.by("email").descending());

        // 7. Pagination + Sort
        studentRepositoryV2
                .findAll(PageRequest.of(pageNo, pageSize, sort))
                .forEach(s -> System.out.println(s.getName()));


    }
}
