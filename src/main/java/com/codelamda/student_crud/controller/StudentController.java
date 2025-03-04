package com.codelamda.student_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codelamda.student_crud.dtos.StudentDTO;
import com.codelamda.student_crud.entities.Student;
import com.codelamda.student_crud.manager.StudentManager;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j // Lombok annotation to auto-generate logger field
public class StudentController {

    private final StudentManager studentManager;

    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @GetMapping("/Students")
    public String getStudents() {
        return "All students";
    }

    @PostMapping("/Student/add")
    public String addStudent(@RequestBody StudentDTO student) {
        log.info("Student added: {}", student);

        Student newStudent = studentManager.createStudent(student.getName(), student.getSurname(), student.getEmail());
        return "Student with id " + newStudent.getId() + " added";

    }

}
