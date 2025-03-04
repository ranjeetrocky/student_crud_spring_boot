package com.codelamda.student_crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codelamda.student_crud.dtos.ApiResponseDTO;
import com.codelamda.student_crud.dtos.StudentDTO;
import com.codelamda.student_crud.entities.Student;
import com.codelamda.student_crud.manager.StudentManager;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j // Lombok annotation to auto-generate logger field
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentManager studentManager;

    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponseDTO> getStudents() {
        return ResponseEntity.ok(ApiResponseDTO.success(studentManager.getStudents()));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponseDTO> addStudent(@RequestBody StudentDTO student) {
        Student newStudent = studentManager.createStudent(student.getName(), student.getSurname(), student.getEmail());
        return ResponseEntity.ok(ApiResponseDTO.success(newStudent));

    }

}
