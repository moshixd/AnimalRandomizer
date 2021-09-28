package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {

        return List.of(
                new Student(
                        1L,
                        "Junior",
                        "http://cdn.akc.org/content/article-body-image/lab_puppy_dog_pictures.jpg",
                        LocalDate.of(2016, Month.JANUARY,11),
                        5

                ), new Student(
                        2L,
                        "Rasmus",
                        "https://media.hswstatic.com/eyJidWNrZXQiOiJjb250ZW50Lmhzd3N0YXRpYy5jb20iLCJrZXkiOiJnaWZcL3B1Zy5qcGciLCJlZGl0cyI6eyJyZXNpemUiOnsid2lkdGgiOjQwMH19fQ==",
                        LocalDate.of(2017, Month.JANUARY,11),
                        4

                )
        );
    }
}
